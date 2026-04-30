package dombrovsky.weather.project.Network

import dombrovsky.weather.project.Models.WeatherData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherAPI {
    private val client = HttpClient {
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }
    suspend fun getWeather(): WeatherData {
        return client.get("https://api.open-meteo.com/v1/forecast"){
            parameter("latitude", "54.9924")
            parameter("longitude", "73.3686")
            parameter("current", "weather_code,temperature_2m,relative_humidity_2m,rain,snowfall")
            parameter("past_days", "0")
            parameter("forecast_days", "7")
        }.body()
    }
}