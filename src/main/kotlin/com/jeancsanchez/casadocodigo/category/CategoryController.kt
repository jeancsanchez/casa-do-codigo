package com.jeancsanchez.casadocodigo.category

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
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
 * @date 13/08/2020.
 * Jesus is alive!
 */

@RestController
@RequestMapping("/categories")
class CategoryController {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @PostMapping
    @Transactional
    fun addNewCategory(@Validated @RequestBody categoryForm: CategoryForm): ResponseEntity<CategoryEntity> {
        val categoryEntity = categoryForm.toEntity()
        entityManager.persist(categoryEntity)
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryEntity)
    }
}