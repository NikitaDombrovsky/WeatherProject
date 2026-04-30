package dombrovsky.weather.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dombrovsky.weather.project.Network.WeatherAPI
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        var weather by remember { mutableStateOf("Загрузка...") }
        val scope = rememberCoroutineScope()
        val api = WeatherAPI()

        LaunchedEffect(Unit){
            scope.launch {
                try {
                    val response = api.getWeather()
                    val temp = response.current.temperature_2m
                    weather = "Температура: $temp"
                } catch (e: Exception){
                    weather = "ОШИБКА! $e"
                }

            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = weather
            )
        }
    }
}