package com.example.shiftusers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.shiftusers.dataUtils.internetUtils.DataParser
import com.example.shiftusers.dataUtils.internetUtils.DataParser.generateUsers
import com.example.shiftusers.dataUtils.internetUtils.DataParser.getOrGenerateUsers
import com.example.shiftusers.dataUtils.internetUtils.DataParser.saveUsersData
import com.example.shiftusers.dataUtils.storageUtils.addUserToDB
import com.example.shiftusers.dataUtils.storageUtils.clearDB
import com.example.shiftusers.dataUtils.storageUtils.getAllUsersFromDB
import com.example.shiftusers.structures.ShiftUser
import com.example.shiftusers.ui.UsersList
import com.example.shiftusers.ui.theme.CustomTheme
import com.example.shiftusers.ui.theme.MainTheme
import com.example.shiftusers.ui.theme.cornersRound
import com.example.shiftusers.ui.theme.spacingMedium
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.serialization.json.Json

var users: MutableList<ShiftUser> = mutableListOf()


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .name("localStorage")
            .build()
        Realm.setDefaultConfiguration(config)

        super.onCreate(savedInstanceState)
        setContent {
            users = remember { mutableListOf<ShiftUser>()}
            getOrGenerateUsers(this).forEach{
                users.add(it)
            }
            MainTheme {
                UsersList(users, ::navigateToDetails)
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacingMedium),
                        shape = RoundedCornerShape(cornersRound),
                        colors = ButtonDefaults.buttonColors(containerColor = CustomTheme.colors.mainCard),
                        onClick = {
                            try {
                                users.clear()
                                generateUsers(this@MainActivity).forEach{
                                    users.add(it)
                                }
                                clearDB()
                                saveUsersData(users)
                            } catch (e: Throwable){
                                Toast.makeText(this@MainActivity, "Ошибка удаления элемента списка при работе с Column", Toast.LENGTH_SHORT).show()
                            }
                        }) {
                        Text(
                            text = "Сгенерировать новых пользователей",
                            color = CustomTheme.colors.primaryText,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }

    fun navigateToDetails(user: ShiftUser){
        val navigate = Intent(this@MainActivity, DetailsActivity::class.java)
        navigate.putExtra("user", Json.encodeToString(ShiftUser.serializer(), user))
        startActivity(navigate)
    }
}