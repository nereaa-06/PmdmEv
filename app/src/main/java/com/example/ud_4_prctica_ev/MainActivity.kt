package com.example.ud_4_prctica_ev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ud_4_prctica_ev.ui.theme.UD_4_Práctica_EVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
// El NavHost define qué pantalla se muestra según la "ruta"
                NavHost(
                    navController = navController,
                    startDestination = "catalogo" // Esta será la pantalla de inicio
                ) {
                    // Ruta para el Catálogo principal
                    composable("catalogo") {
                        CatalogoScreen(navController)
                    }

                    // --- RUTAS PARA EL LIBRO 1
                    composable("audio1") {
                        AudioScreen(navController)
                    }
                    composable("video1") {
                        VideoScreen(navController)
                    }

                    // --- RUTAS PARA EL LIBRO 2
                    composable("audio2") {
                        AudioScreen2(navController)
                    }
                    composable("video2") {
                        VideoScreen2(navController)
                    }
                }
            }
            }
        }
    }



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD_4_Práctica_EVTheme {
        Greeting("Android")
    }
}