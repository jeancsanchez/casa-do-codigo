package com.jeancsanchez.casadocodigo.category

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/08/2020.
 * Jesus is alive!
 */

@Entity
class CategoryEntity
@JsonCreator(mode = JsonCreator.Mode.PROPERTIES) constructor(

        @Column(nullable = false)
        @NotBlank
        private val name: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}