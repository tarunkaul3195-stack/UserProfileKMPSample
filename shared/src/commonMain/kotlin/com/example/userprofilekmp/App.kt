package com.example.userprofilekmp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun App() {
    MaterialTheme {
        val repository = remember { UserRepository() }
        val viewModel = remember { UserViewModel(repository) }
        val uiState by viewModel.uiState.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.fetchUser(6)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F5F5)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 48.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "User Profile",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 26.dp)
                )

                when (val state = uiState) {
                    is UserUiState.Loading -> {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }
                    is UserUiState.Success -> {
                        UserCard(state.user, state.deviceName, modifier = Modifier.weight(1f))
                    }
                    is UserUiState.Error -> {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text("Error: ${state.message}", color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserCard(user: User, deviceName: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(28.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(220.dp)
                        .padding(6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Gray square background
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFFF2F2F2),
                        shape = RoundedCornerShape(8.dp)
                    ) {}

                    KamelImage(
                        resource = asyncPainterResource(user.image),
                        contentDescription = "User Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(130.dp)
                    )
                }
            }

            InfoSection(label = "Name", value = "${user.firstName} ${user.lastName}")
            Spacer(modifier = Modifier.height(14.dp))
            InfoSection(label = "Age", value = user.age.toString())
            Spacer(modifier = Modifier.height(14.dp))
            InfoSection(label = "Gender", value = user.gender)
            Spacer(modifier = Modifier.height(14.dp))
            InfoSection(label = "Device Name", value = deviceName)
        }
    }
}

@Composable
fun InfoSection(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}
