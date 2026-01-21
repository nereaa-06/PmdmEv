package com.example.ud_4_prctica_ev
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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

        // 3. BOTONES DE NAVEGACIÓN
        Button(
            onClick = { navController.navigate("audio") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Escuchar Audio")
        }

        Button(
            onClick = { navController.navigate("video") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Vídeo ")
        }

        // 2. IMAGEN REMOTA
        AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("https://lumiere-a.akamaihd.net/v1/images/image_8ac3fa97.jpeg?region=0%2C0%2C540%2C810")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.error),
                contentDescription = "Imagen descargada desde Internet",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 3. BOTONES DE NAVEGACIÓN
        Button(
            onClick = { navController.navigate("audio") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Escuchar Audio")
        }

        Button(
            onClick = { navController.navigate("video") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Vídeo ")
        }


    }
}