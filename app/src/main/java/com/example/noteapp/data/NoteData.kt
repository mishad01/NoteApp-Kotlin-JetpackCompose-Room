package com.example.noteapp.data
import com.example.noteapp.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation by the lake."), // short
            Note(title = "Android Compose", description = "Working on Android Compose course today. Learning about Composables, state management, and theming."), // medium
            Note(title = "Keep at it...", description = "Sometimes things just happen, and life throws curveballs at us. The important thing is to keep moving forward and never lose hope, no matter how tough it gets."), // long
            Note(title = "A movie day", description = "Watching a movie with family today."), // short
            Note(title = "Project Ideas", description = "Brainstorming some new project ideas for the upcoming hackathon. Thinking of building a social media app with innovative features like AI-based content recommendations and real-time collaboration."), // medium
            Note(title = "Travel Plans", description = "Planning a trip to the mountains next month. Need to prepare the itinerary, book accommodations, and make sure all travel documents are ready. Excited to disconnect and enjoy nature for a while."), // long
            Note(title = "Groceries", description = "Buy milk, eggs, bread, and some fresh vegetables."), // short
            Note(title = "Reading List", description = "Currently reading 'Clean Code' by Robert C. Martin. Also planning to start 'The Pragmatic Programmer' next week."), // medium
            Note(title = "Fitness Goals", description = "Want to start running every morning and do strength training three times a week. Track progress with a fitness app and stay motivated with friends."), // medium
            Note(title = "Daily Reminder", description = "Remember to take breaks regularly and stay hydrated throughout the day to maintain productivity and focus."),
            Note(title = "A good day", description = "We went on a vacation by the lake."), // short
            Note(title = "Android Compose", description = "Working on Android Compose course today. Learning about Composables, state management, and theming."), // medium
            Note(title = "Keep at it...", description = "Sometimes things just happen, and life throws curveballs at us. The important thing is to keep moving forward and never lose hope, no matter how tough it gets."), // long
            Note(title = "A movie day", description = "Watching a movie with family today."), // short
            Note(title = "Project Ideas", description = "Brainstorming some new project ideas for the upcoming hackathon. Thinking of building a social media app with innovative features like AI-based content recommendations and real-time collaboration."), // medium
            Note(title = "Travel Plans", description = "Planning a trip to the mountains next month. Need to prepare the itinerary, book accommodations, and make sure all travel documents are ready. Excited to disconnect and enjoy nature for a while."), // long
            Note(title = "Groceries", description = "Buy milk, eggs, bread, and some fresh vegetables."), // short
            Note(title = "Reading List", description = "Currently reading 'Clean Code' by Robert C. Martin. Also planning to start 'The Pragmatic Programmer' next week."), // medium
            Note(title = "Fitness Goals", description = "Want to start running every morning and do strength training three times a week. Track progress with a fitness app and stay motivated with friends."), // medium
            Note(title = "Daily Reminder", description = "Remember to take breaks regularly and stay hydrated throughout the day to maintain productivity and focus.") // medium
        )
    }
}
