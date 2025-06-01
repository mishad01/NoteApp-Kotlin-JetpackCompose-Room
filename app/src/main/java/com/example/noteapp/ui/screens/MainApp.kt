package com.example.noteapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.noteapp.HomeScreen
import com.example.noteapp.data.NotesDataSource

@Composable
fun MainApp(navController: NavController){
    HomeScreen(
        onAddNote = { },
        onRemoveNote = {},
        notes = NotesDataSource().loadNotes(),
        navController = navController
    )
}