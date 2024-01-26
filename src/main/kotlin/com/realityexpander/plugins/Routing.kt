package com.realityexpander.plugins

import com.google.firebase.messaging.FirebaseMessaging
import com.realityexpander.SendMessageDto
import com.realityexpander.toMessage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        route("/send") {
            post {
                val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                    call.respond(HttpStatusCode.BadRequest)
                    return@post
                }

                FirebaseMessaging.getInstance().send(body.toMessage())

                call.respond(HttpStatusCode.OK)
            }
        }

        route("/broadcast") {
            post {
                val body = call.receiveNullable<SendMessageDto>() ?: kotlin.run {
                    call.respond(HttpStatusCode.BadRequest)
                    return@post
                }

                FirebaseMessaging.getInstance().send(body.toMessage())

                call.respond(HttpStatusCode.OK)
            }
        }
    }
}
