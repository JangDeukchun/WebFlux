package io.dustin.common.configuration

import io.dustin.api.router.mugi.ReadMugiHandler
import io.dustin.api.router.mugi.WriteMugiHandler
import io.dustin.api.router.user.ReadUserHandler
import io.dustin.api.router.user.WriteUserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfiguration {
    @Bean
    fun readUserRouter(handler: ReadUserHandler): RouterFunction<ServerResponse> {
        return router {
            "/api/v1/users".nest {
                accept(APPLICATION_JSON).nest {
                    GET("/{id}", handler::userById)
                    GET("/query/{queryCondition}", handler::userByQuery)
                }
            }
        }
    }

    @Bean
    fun writeUserRouter(handler: WriteUserHandler): RouterFunction<ServerResponse> {
        return router {
            "/api/v1/users".nest {
                accept(APPLICATION_JSON).nest {
                    POST("", handler::insert)
                    PATCH("/{id}", handler::update)
                }
            }
        }
    }

    @Bean
    fun readMugiRouter(handler: ReadMugiHandler): RouterFunction<ServerResponse> {
        return router {
            "/api/v1/mugis".nest {
                accept(APPLICATION_JSON).nest {
                    GET("/{id}", handler::mugiById)
                    GET("/user/{userId}", handler::mugiByUserId)
                    GET("/query/{queryCondition}", handler::allMugis)
                }
            }
        }
    }

    @Bean
    fun writeMugiRouter(handler: WriteMugiHandler): RouterFunction<ServerResponse> {
        return router {
            "/api/v1/mugis".nest {
                accept(APPLICATION_JSON).nest {
                    POST("", handler::insert)
                    PATCH("/{id}", handler::update)
                }
            }
        }
    }


}