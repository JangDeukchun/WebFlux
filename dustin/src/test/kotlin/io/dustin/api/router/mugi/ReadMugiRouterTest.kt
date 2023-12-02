package io.dustin.api.router.mugi

import io.dustin.domain.mugi.model.Mugi
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
class ReadMugiRouterTest @Autowired constructor(
        private var webTestClient: WebTestClient,
) {

    @Test
    @DisplayName("mugiById router test")
    fun mugiByIdTEST() {
        // given
        val id = "1"

        // when
        webTestClient.get()
                .uri("/api/v1/mugis/{id}", id)
                .exchange()
                .expectStatus().isOk
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBody(Mugi::class.java)
                // then
                .value { mugi ->
                    assertThat(mugi.name).isEqualTo("Bird At St. Nick's")
                }
    }

    @Test
    @DisplayName("mugiByUserId router test")
    fun mugiByUserIdTEST() {

        // given
        val userId = 1
        val page = 1
        val size = 10

        // when
        webTestClient.get()
                .uri("/api/v1/mugis/user/{userId}?page=$page&size=$size", userId)
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                // then
                .jsonPath("$.content[0].user.name").isEqualTo("한동근")

    }

    @Test
    @DisplayName("allmugis adjust Matrix Variable router test")
    fun allmugisTEST() {

        // given
        val page = 1
        val size = 10

        // when
        webTestClient.get()
                .uri("/api/v1/mugis/query/search;label=like,Verve?page=$page&size=$size")
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                // then
                .jsonPath("$.[0].label").isEqualTo("Verve")

    }

}