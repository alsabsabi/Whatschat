package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.screens.*
import com.example.ui.theme.WhatsChatTheme
import com.example.ui.viewmodels.ChatViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: ChatViewModel = viewModel()
            val isDarkMode by viewModel.isDarkMode.collectAsState()
            val currentUser by viewModel.currentUser.collectAsState()

            WhatsChatTheme(darkTheme = isDarkMode) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    val startDestination = if (currentUser == null) "onboarding" else "home"

                    NavHost(
                        navController = navController,
                        startDestination = startDestination
                    ) {
                        composable("onboarding") {
                            OnboardingScreen(
                                viewModel = viewModel,
                                onFinish = {
                                    navController.navigate("home") {
                                        popUpTo("onboarding") { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable("home") {
                            HomeScreen(
                                viewModel = viewModel,
                                onOpenChat = { chatId ->
                                    navController.navigate("chat/$chatId")
                                },
                                onOpenSettings = {
                                    navController.navigate("settings")
                                },
                                onOpenCall = { contactName, isVideo ->
                                    navController.navigate("active_call/$contactName/$isVideo")
                                }
                            )
                        }

                        composable("chat/{chatId}") { backStackEntry ->
                            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
                            ChatDetailScreen(
                                chatId = chatId,
                                viewModel = viewModel,
                                onBack = { navController.popBackStack() },
                                onCall = { name, isVideo ->
                                    navController.navigate("active_call/$name/$isVideo")
                                }
                            )
                        }

                        composable("settings") {
                            SettingsScreen(
                                viewModel = viewModel,
                                onBack = { navController.popBackStack() },
                                onResetProfile = {
                                    navController.navigate("onboarding") {
                                        popUpTo("home") { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable("active_call/{contactName}/{isVideo}") { backStackEntry ->
                            val contactName = backStackEntry.arguments?.getString("contactName") ?: "Contact"
                            val isVideo = backStackEntry.arguments?.getString("isVideo")?.toBoolean() ?: false
                            ActiveCallScreen(
                                contactName = contactName,
                                isVideo = isVideo,
                                viewModel = viewModel,
                                onEndCall = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
