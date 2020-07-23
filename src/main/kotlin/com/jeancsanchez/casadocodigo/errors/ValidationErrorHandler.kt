package com.jeancsanchez.casadocodigo.errors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

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
}