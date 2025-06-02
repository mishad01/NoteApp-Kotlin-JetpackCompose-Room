package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.model.Note
import com.example.noteapp.ui.utils.NoteTypeConverters

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(NoteTypeConverters::class)

abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}