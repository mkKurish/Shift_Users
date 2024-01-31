package com.example.shiftusers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shiftusers.dataUtils.internetUtils.DataParser
import com.example.shiftusers.structures.ShiftUser
import com.example.shiftusers.ui.UsersList
import com.example.shiftusers.ui.theme.MainTheme
import kotlinx.serialization.json.Json

var users: List<ShiftUser> = listOf()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        users = DataParser.generateUsers(this, 15)

        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                UsersList(users, ::navigateToDetails)
            }
        }
    }

    fun navigateToDetails(user: ShiftUser){
        val navigate = Intent(this@MainActivity, DetailsActivity::class.java)
        navigate.putExtra("user", Json.encodeToString(ShiftUser.serializer(), user))
        startActivity(navigate)
    }
}