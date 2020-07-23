package com.jeancsanchez.casadocodigo

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext
import javax.inject.Inject

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner::class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener::class)
abstract class BaseControllerTests {

    @Inject
    protected lateinit var context: WebApplicationContext

    protected lateinit var mvc: MockMvc

    protected val jsonContentType = APPLICATION_JSON

    protected val mapper = ObjectMapper()

    @Before
    fun setUp() {
        mvc = webAppContextSetup(context).build()
    }
}