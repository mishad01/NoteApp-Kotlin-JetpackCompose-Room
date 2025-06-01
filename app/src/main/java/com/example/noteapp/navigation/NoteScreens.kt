package com.example.noteapp.navigation

enum class NoteScreens{
    MainApp,
    AddEditNoteScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route: String?): NoteScreens = when(route?.substringBefore("/")){
            MainApp.name -> MainApp
            AddEditNoteScreen.name -> AddEditNoteScreen
            DetailsScreen.name -> DetailsScreen
            null -> MainApp
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}