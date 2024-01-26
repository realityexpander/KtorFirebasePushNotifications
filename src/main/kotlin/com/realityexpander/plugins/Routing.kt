package com.realityexpander.plugins

import com.realityexpander.sendNotification
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        sendNotification()
    }
}
