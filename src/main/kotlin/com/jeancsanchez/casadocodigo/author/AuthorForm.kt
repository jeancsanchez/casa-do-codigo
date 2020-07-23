package com.jeancsanchez.casadocodigo.author

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

data class AuthorForm(
        @field:NotEmpty(message = "Name cannot be empty")
        var name: String = "",

        @field:Email(message = "Email should be valid")
        @field:NotEmpty(message = "Email cannot be empty")
        var email: String = "",

        @field:NotEmpty(message = "Description cannot be empty")
        @field:Size(min = 1, max = 400)
        var description: String = ""
) {

    fun toEntity(): AuthorEntity = AuthorEntity(name = name, email = email, description = description)
}