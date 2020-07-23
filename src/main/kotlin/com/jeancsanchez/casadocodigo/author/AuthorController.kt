package com.jeancsanchez.casadocodigo.author

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import javax.validation.Valid

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

@RestController
@RequestMapping("/authors")
class AuthorController {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @PostMapping
    @Transactional
    fun addNewAuthor(@Valid @RequestBody authorForm: AuthorForm): ResponseEntity<AuthorEntity> {
        val author = authorForm.toEntity()
        entityManager.persist(author)
        return ResponseEntity.status(HttpStatus.CREATED).body(author)
    }
}