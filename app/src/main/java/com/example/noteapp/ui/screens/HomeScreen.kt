package com.example.noteapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.ui.theme.interFontFamily
import com.example.noteapp.ui.utils.noteCardColors
import com.example.noteapp.ui.widgets.NoteCard

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    notes: List<Note>,
    navController: NavController? = null

) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                //colors = TopAppBarDefaults.topAppBarColors(Color.Yellow),
                modifier = Modifier.padding(horizontal = 18.dp),
                title = {
                    Text(
                        "Recent Notes", style = TextStyle(
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            letterSpacing = 0.sp
                        )
                    )
                },

                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }

            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    navController?.navigate("AddEditNoteScreen")
                },
                shape = CircleShape,
                containerColor = Color(
                    0xFFE8505B
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }) { paddingValues ->
        GridItems(paddingValues, notes, navController)
    }
}

@Composable
private fun GridItems(
    paddingValues: PaddingValues,
    notes: List<Note>,
    navController: NavController?
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .padding(paddingValues)
            .padding(18.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalItemSpacing = Dp(12F)
    ) {
        itemsIndexed(notes) { index, item ->
            val backGroundColor = noteCardColors[index % noteCardColors.size]
            NoteCard(
                notes = item,
                backGroundColor = backGroundColor
            ) {
                navController?.navigate("DetailsScreen/${item.title}/${item.description}")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen(
        notes = NotesDataSource().loadNotes(),
    )
}
