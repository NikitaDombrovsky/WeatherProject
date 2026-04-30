package dombrovsky.weather.project.Models

import kotlinx.serialization.Serializable

@Serializable
data class Current (
    val weather_code: Int,
    val temperature_2m: Double,
    val relative_humidity_2m: Double,
    val rain: Double ,
    val snowfall: Double
)