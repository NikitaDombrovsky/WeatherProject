package dombrovsky.weather.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform