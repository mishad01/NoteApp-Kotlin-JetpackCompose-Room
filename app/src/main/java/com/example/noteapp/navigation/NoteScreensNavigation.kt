package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.AddEditNoteScreen
import com.example.noteapp.HomeScreen
import com.example.noteapp.ui.screens.AddEditNoteScreen
import com.example.noteapp.ui.screens.HomeScreen
import com.example.noteapp.ui.screens.MainApp

@Composable
fun NoteScreensNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = NoteScreens.MainApp.name
    ) {
        composable(NoteScreens.MainApp.name) {
            //Here we pass where this lead us to
            MainApp(navController = navController)
        }
        composable(NoteScreens.AddEditNoteScreen.name) {
            AddEditNoteScreen(navController = navController)
        }
    }
}