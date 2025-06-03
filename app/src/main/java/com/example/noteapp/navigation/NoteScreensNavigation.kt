package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.ui.screens.AddEditNoteScreen
import com.example.noteapp.ui.screens.DetailsScreen
import com.example.noteapp.ui.screens.MainApp

@Composable
fun NoteScreensNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = NoteScreens.MainApp.name
    ) {
        composable(NoteScreens.MainApp.name) {
            //Here we pass where this lead us to
            MainApp(
                navController = navController,
                noteViewModel = hiltViewModel()
            )
        }
        composable(NoteScreens.AddEditNoteScreen.name) {
            AddEditNoteScreen(navController = navController)
        }
        composable(
            NoteScreens.DetailsScreen.name + "/{title}/{description}",
            arguments = listOf(
                navArgument(name = "title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            DetailsScreen(
                navController = navController,
                title,
                description
            )
        }
    }
}