package com.jeancsanchez.casadocodigo

import com.jeancsanchez.casadocodigo.category.CategoryForm
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

internal class CategoryControllerTest : BaseControllerTests() {

    private val categoryForm = CategoryForm(name = "Programming")

    @Test
    fun whenNameIsValid_thenReturnsStatus201() {
        val body = mapper.writeValueAsString(categoryForm)
        mvc.perform(post("/categories")
                .contentType(jsonContentType)
                .content(body))
                .andExpect(status().isCreated)
    }

    @Test
    fun whenNameIsInvalid_thenReturnsStatus400() {
        val body = mapper.writeValueAsString(categoryForm.copy(name = ""))
        mvc.perform(post("/categories")
                .contentType(jsonContentType)
                .content(body))
                .andExpect(status().isBadRequest)
    }
}
