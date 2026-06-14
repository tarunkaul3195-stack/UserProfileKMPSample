package com.example.userprofilekmp

interface Platform {
    val name: String
    val deviceName: String
}

expect fun getPlatform(): Platform