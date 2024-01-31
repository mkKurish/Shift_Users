package com.example.shiftusers.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.shiftusers.structures.DoB
import com.example.shiftusers.structures.Location
import com.example.shiftusers.structures.Registration
import com.example.shiftusers.ui.theme.CustomTheme
import com.example.shiftusers.ui.theme.cornersRadius
import com.example.shiftusers.ui.theme.spacingMedium
import com.example.shiftusers.ui.theme.spacingSmall

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfileMainInfo(fullName: String, title: String, pic: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(cornersRadius),
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = rememberImagePainter(pic),
                contentDescription = "Profile picture",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(spacingMedium))
        Row {
            Text(
                text = title.toString(), color = CustomTheme.colors.secondaryText,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.size(spacingSmall))
            Text(
                text = fullName, color = CustomTheme.colors.primaryText,
                fontSize = 24.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsInfo(email: String, phone: String, cell: String, callback: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingSmall),
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = {
                callback(phone)
            },
            modifier = Modifier
                .padding(spacingSmall),
            colors = ButtonDefaults.buttonColors(containerColor = CustomTheme.colors.mainCard),
            shape = RoundedCornerShape(cornersRadius)
        ) {
            Text(
                modifier = Modifier.background(Color.Transparent),
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                        append("phone: ")
                    }
                    withStyle(style = SpanStyle(color = CustomTheme.colors.primaryText)) {
                        append(phone)
                    }
                },
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.size(spacingSmall))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("cell: ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.primaryText)) {
                    append(cell)
                }
            },
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(spacingSmall))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("email: ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.primaryText)) {
                    append(email)
                }
            },
            fontSize = 18.sp
        )
    }
}

@Composable
fun LocationInfo(location: Location) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingMedium),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("location: ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("${location.country}, ${location.city}, ${location.street}")
                }
            },
            color = CustomTheme.colors.primaryText,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(spacingSmall))
        Text(
            text = "postcode: ${location.postcode}", color = CustomTheme.colors.primaryText,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(spacingSmall))
        Text(
            text = "timezone: ${location.timezone!!.offset} (${location.timezone!!.description})",
            color = CustomTheme.colors.primaryText,
            fontSize = 18.sp
        )
    }
}

@Composable
fun RegistrationAndBirthInfo(dob: DoB, registration: Registration) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingMedium),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("Birth date: ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.primaryText)) {
                    append("${dob.date} ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("(${dob.age} years old)")
                }
            },
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.size(spacingSmall))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("Registration: ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.primaryText)) {
                    append("${registration.date} ")
                }
                withStyle(style = SpanStyle(color = CustomTheme.colors.secondaryText)) {
                    append("(${registration.age} years old)")
                }
            },
            color = CustomTheme.colors.primaryText,
            fontSize = 18.sp
        )
    }
}