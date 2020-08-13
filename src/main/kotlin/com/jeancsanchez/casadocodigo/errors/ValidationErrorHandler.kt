package com.jeancsanchez.casadocodigo.errors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException
import java.lang.IllegalArgumentException
import javax.persistence.PersistenceException
import javax.validation.ConstraintViolationException

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */
@RestControllerAdvice
class ValidationErrorHandler {

    @Autowired
    private lateinit var messageSource: MessageSource

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(exception: MethodArgumentNotValidException): List<ErrorResponseDTO> {
        return exception.bindingResult.fieldErrors.map {
            val message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            ErrorResponseDTO(field = it.field, message = message)
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintError(exception: ConstraintViolationException): List<ErrorResponseDTO> {
        return listOf(ErrorResponseDTO("erro", "Erro de contraint"))
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(PersistenceException::class)
    fun handleValidationError(exception: PersistenceException): List<ErrorResponseDTO> {
        return listOf(ErrorResponseDTO("erro", "Erro de integridade referencial"))
    }
}