package com.jeancsanchez.casadocodigo.category

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/08/2020.
 * Jesus is alive!
 */

data class CategoryForm(
        @field:NotEmpty(message = "Name cannot be empty")
        var name: String = ""
) {

    fun toEntity(): CategoryEntity = CategoryEntity(name = name)
}