package com.example.noteapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.ui.utils.InputTextField
import com.example.noteapp.ui.utils.noteCardColors
import com.example.noteapp.ui.widgets.NoteCard

@Composable
fun AddEditNoteScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            val title = remember { mutableStateOf("") }
            val description = remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding())
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputTextField(
                    text = title.value,
                    label = "Title",
                    onTextChange = {
                        if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) {
                            title.value = it
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                InputTextField(
                    text = description.value,
                    label = "Description",
                    onTextChange = {
                        if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) {
                            description.value = it
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    Text("Save")
                }

                // This handles bottom spacing automatically
                GridItems(notes = NotesDataSource().loadNotes())
            }
        }
    }
}

@Composable
private fun GridItems(
    notes: List<Note>
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .padding(18.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalItemSpacing = Dp(12F)
    ) {
        itemsIndexed(notes) { index, item ->
            val backGroundColor = noteCardColors[index % noteCardColors.size]
            NoteCard(notes = item, backGroundColor = backGroundColor)
        }
    }
}
@Preview
@Composable
fun AddEditNoteScreenPreview() {
    val navController = rememberNavController()
    AddEditNoteScreen(navController = navController)
}
