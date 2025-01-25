package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Add(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Add(modifier: Modifier = Modifier) {
    // États pour les deux nombres et le résultat
    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Additionnez deux nombres", style = MaterialTheme.typography.titleLarge)

        // Champ pour le premier nombre
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Premier nombre") }
        )

        // Champ pour le deuxième nombre
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Deuxième nombre") }
        )

        // Bouton pour effectuer l'addition
        Button(
            onClick = {
                // Effectuer l'addition si les champs ne sont pas vides
                val n1 = num1.text.toIntOrNull() ?: 0
                val n2 = num2.text.toIntOrNull() ?: 0
                result = n1 + n2
            }
        ) {
            Text("Additionner")
        }

        // Affichage du résultat
        Text(text = "Résultat : $result", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun AddPreview() {
    MyApplicationTheme {
        Add()
    }
}
