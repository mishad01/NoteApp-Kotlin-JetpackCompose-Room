package com.example.noteapp.ui.screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun MainApp(
    navController: NavController,
    noteViewModel: NoteViewModel = hiltViewModel()
) {
    val notesList = noteViewModel.noteList.collectAsState(initial = emptyList()).value
    HomeScreen(
        notes = notesList,
        navController = navController
    )
}

