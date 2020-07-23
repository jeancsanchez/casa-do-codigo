package com.jeancsanchez.casadocodigo

import com.jeancsanchez.casadocodigo.author.AuthorForm
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

internal class AuthorEntityControllerTest : BaseControllerTests() {

    private val authorForm = AuthorForm(name = "newAuthor", email = "validemail@email.com", description = "Hello")

    @Test
    fun whenEmailIsValid_thenReturnsStatus201() {
        val body = mapper.writeValueAsString(authorForm)
        mvc.perform(post("/authors")
                .contentType(jsonContentType)
                .content(body))
                .andExpect(status().isCreated)
    }

    @Test
    fun whenEmailIsInvalid_thenReturnsStatus400() {
        val body = mapper.writeValueAsString(authorForm.copy(email = "invalidEmailDotCom"))
        mvc.perform(post("/authors")
                .contentType(jsonContentType)
                .content(body))
                .andExpect(status().isBadRequest)
    }
}
