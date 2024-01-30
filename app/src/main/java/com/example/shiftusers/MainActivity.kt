package com.example.shiftusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shiftusers.dataUtils.internetUtils.DataParser
import com.example.shiftusers.structures.ShiftUser
import com.example.shiftusers.ui.theme.ShiftUsersTheme

var users: List<ShiftUser> = listOf()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        users = DataParser.generateUsers(this, 2)

        super.onCreate(savedInstanceState)
        setContent {
            ShiftUsersTheme {

            }
        }
    }
}