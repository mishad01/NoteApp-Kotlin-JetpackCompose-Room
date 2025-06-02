package com.example.noteapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.ui.theme.interFontFamily
import com.example.noteapp.ui.utils.InputTextField
import com.example.noteapp.ui.utils.noteCardColors
import com.example.noteapp.ui.widgets.NoteCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteViewModel: NoteViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                //colors = TopAppBarDefaults.topAppBarColors(Color.Yellow),
                modifier = Modifier.padding(horizontal = 18.dp),
                title = {
                    Text(
                        "Add Notes", style = TextStyle(
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            letterSpacing = 0.sp
                        )
                    )
                },

                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Menu",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }

            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
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
                    onClick = {
                        val note = Note(
                            title = title.value,
                            description = description.value
                        )
                        noteViewModel.addNote(
                            note = note
                        )
                    },
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    Text("Save")
                }
                GridItems(notes = noteViewModel.getAllNotes(), noteViewModel)
            }
        }
    }
}

@Composable
private fun GridItems(
    notes: List<Note>,
    viewModel: NoteViewModel
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
            NoteCard(notes = item, backGroundColor = backGroundColor) {
                viewModel.removeNote(item)
            }
        }
    }
}

@Preview
@Composable
fun AddEditNoteScreenPreview() {
    val navController = rememberNavController()
    AddEditNoteScreen(navController = navController)
}
