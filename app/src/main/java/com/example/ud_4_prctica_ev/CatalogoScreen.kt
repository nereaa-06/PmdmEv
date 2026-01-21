package com.example.ud_4_prctica_ev
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun CatalogoScreen(navController: NavHostController) {
    val context = LocalContext.current
    // Usamos Scroll para asegurar que todo se vea
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Añade esto
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = "Mi App de Audiolibros", style = MaterialTheme.typography.headlineMedium)

        // 1. IMAGEN LOCAL
        Image(
            painter = painterResource(id = R.drawable.portada_alicia),
            contentDescription = "Portada Local",
            modifier = Modifier.size(200.dp)
        )

        // 3. BOTONES
        Button(onClick = { navController.navigate("audio1") }) {
            Text("Escuchar Audio")
        }

        Button(onClick = { navController.navigate("video1") }) {
            Text("Ver Vídeo")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // 2. IMAGEN REMOTA
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://static.wikia.nocookie.net/sherlockholmes/images/b/b8/Sherlock_Holmes_%28Cumberbatch%29.png/revision/latest/scale-to-width-down/369?cb=20140114144605&path-prefix=es")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.error),
            contentDescription = "Imagen remota",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        // 3. BOTONES
        Button(onClick = { navController.navigate("audio2") }) {
            Text("Escuchar Audio")
        }
        Button(onClick = { navController.navigate("video2") }) {
            Text("Ver Vídeo")
        }
    }
}