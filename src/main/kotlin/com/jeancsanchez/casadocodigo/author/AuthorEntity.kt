package com.jeancsanchez.casadocodigo.author

import java.util.*
import javax.persistence.*

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 23/07/2020.
 * Jesus is alive!
 */

@Entity
class AuthorEntity(
        @Column(nullable = false)
        private val name: String = "",

        @Column(unique = true, nullable = false)
        private val email: String = "",

        @Column(length = 400)
        private val description: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0

    @Temporal(TemporalType.TIMESTAMP)
    private val timestamp: Date = Date()
}