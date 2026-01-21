package com.example.ud_4_prctica_ev




import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AudioScreen2(navController: NavHostController) {
    val context = LocalContext.current

    val player = remember {
        MediaPlayer.create(context, R.raw.memorias_sherlock)
    }


    DisposableEffect(Unit) {
        onDispose {
            // Si está sonando, lo paramos y liberamos recursos
            try {
                if (player.isPlaying) {
                    player.stop()
                }
            } catch (_: IllegalStateException) {

            }
            player.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Audio",
            style = MaterialTheme.typography.titleLarge
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = {
                    // Play reproduce desde la posición actual
                    if (!player.isPlaying) {
                        player.start()
                    }
                }
            ) {
                Text("Play")
            }

            Button(
                onClick = {
                    // Pause pausa solo si está reproduciendo
                    if (player.isPlaying) {
                        player.pause()
                    }
                }
            ) {
                Text("Pause")
            }

            Button(
                onClick = {
                    // Reiniciar vuelve al inicio sin auto play
                    player.seekTo(0)
                    if (player.isPlaying) {
                        player.pause()
                    }
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}