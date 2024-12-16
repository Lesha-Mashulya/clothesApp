package com.example.clothesapp.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapScreen()
        }
    }
}

@Composable
fun MapScreen() {

    val newYork = LatLng(40.7128, -74.0060)

    val statueOfLiberty = LatLng(40.6892, -74.0445)
    val empireStateBuilding = LatLng(40.748817, -73.985428)
    val centralPark = LatLng(40.785091, -73.968285)

    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(newYork, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = newYork),
            title = "Market1",
            snippet = "Adidas"
        )
        Marker(
            state = MarkerState(position = statueOfLiberty),
            title = "Market2",
            snippet = "Nike"
        )
        Marker(
            state = MarkerState(position = empireStateBuilding),
            title = "Market3",
            snippet = "Puma"
        )
        Marker(
            state = MarkerState(position = centralPark),
            title = "Market4",
            snippet = "Zara"
        )
    }
}
