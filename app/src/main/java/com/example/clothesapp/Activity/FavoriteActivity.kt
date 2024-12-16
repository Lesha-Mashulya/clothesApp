package com.example.clothesapp.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class FavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavoriteScreen()
        }
    }
}

@Composable
fun FavoriteScreen() {
    var showImages by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Update text to "Our Best Items"
        Text(
            text = "Our Best Items",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Button to toggle image display
        Button(
            onClick = { showImages = !showImages },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,  // Черный фон
                contentColor = Color.White    // Белый текст
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Show Images")
        }

        // Show the images if showImages is true
        if (showImages) {
            ImageList()
        }
    }
}

@Composable
fun ImageList() {
    val images = listOf(
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/a951b0f1a084a52c18b46e86a43095e391dd658a.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/c993cde3c856c095b8d58ea5d453997de8feb272.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/03/2ca69950967f49fd8960cea062c827f178d6bf8b.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/de38bf9001306109213349bf823ab38a7b3ed5e8.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/a44008ea6073740d3f411f15a67fcf4339d22a8f.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/228e5d9196c4ee645ce09f0c1439117164731bf8.jpg?q=100&w=1920",
        "https://cache-limeshop.cdnvideo.ru/limeshop/2024/12/12/e93b767f1a103118367f36d2f03f22ef37263e40.jpg?q=100&w=1920",
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(images.size) { index ->
            ImageCard(imageUrl = images[index])
        }
    }
}

@Composable
fun ImageCard(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}