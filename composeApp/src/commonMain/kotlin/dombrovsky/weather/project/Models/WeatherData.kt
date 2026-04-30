package dombrovsky.weather.project.Models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    val current: Current
)
