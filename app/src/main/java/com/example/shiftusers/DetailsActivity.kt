package com.example.shiftusers

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shiftusers.structures.ShiftUser
import com.example.shiftusers.ui.ContactsInfo
import com.example.shiftusers.ui.LocationInfo
import com.example.shiftusers.ui.ProfileMainInfo
import com.example.shiftusers.ui.RegistrationAndBirthInfo
import com.example.shiftusers.ui.theme.CustomTheme
import com.example.shiftusers.ui.theme.MainTheme
import com.example.shiftusers.ui.theme.cornersRound
import kotlinx.serialization.json.Json

class DetailsActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        val encodedUser = intent.getStringExtra("user")
        val user: ShiftUser?
        encodedUser.let {
            if (it != null)
                user = Json.decodeFromString(it)
            else {
                user = null
                Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_SHORT).show()
                navigate(this@DetailsActivity, MainActivity::class.java)
            }
        }

        super.onCreate(savedInstanceState)

        setContent {
            MainTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = CustomTheme.colors.background)
                ) {
                    ProfileMainInfo(
                        "${user!!.name!!.first} ${user.name!!.last}",
                        user.name!!.title!!,
                        user.picture!!.large!!
                    )
                    ContactsInfo(email = user.email!!, phone = user.phone!!, cell = user.cell!!) {
                        Toast.makeText(this@DetailsActivity, it, Toast.LENGTH_SHORT).show()
                    }
                    LocationInfo(location = user.location!!)
                    RegistrationAndBirthInfo(dob = user.dob!!, registration = user.registered!!)
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(24.dp),
                    contentAlignment = Alignment.BottomEnd,
                ) {
                    Button(
                        shape = RoundedCornerShape(cornersRound),
                        colors = ButtonDefaults.buttonColors(containerColor = CustomTheme.colors.mainCard),
                        onClick = {
                            navigate(this@DetailsActivity, MainActivity::class.java)
                        }) {
                        Text(
                            text = "Назад",
                            color = CustomTheme.colors.primaryText,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }

    private fun navigate(packageContext: Context, cls: Class<*>) {
        val intent = Intent(packageContext, cls)
        startActivity(intent)
    }
}