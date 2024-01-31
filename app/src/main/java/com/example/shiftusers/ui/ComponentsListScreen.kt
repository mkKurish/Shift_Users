package com.example.shiftusers.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.shiftusers.structures.ShiftUser
import com.example.shiftusers.ui.theme.CustomTheme
import com.example.shiftusers.ui.theme.cornersRound
import com.example.shiftusers.ui.theme.spacingSmall

@Composable
fun UsersList(content: List<ShiftUser>, navigation: (ShiftUser) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.background)
            .padding(horizontal = spacingSmall)
    ) {
        content.forEach {
            item {
                ListItem(it, navigation)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ListItem(user: ShiftUser, navigation: (ShiftUser) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingSmall),
        onClick = {
            navigation(user)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CustomTheme.colors.mainCard)
        ) {
            Card(
                modifier = Modifier
                    .size(64.dp)
                    .padding(spacingSmall),
                shape = RoundedCornerShape(cornersRound)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberImagePainter(user.picture!!.medium),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.size(spacingSmall))
            Column(
                modifier = Modifier.height(64.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${user.name!!.first} ${user.name!!.last}",
                    color = CustomTheme.colors.primaryText
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = user.phone!!,
                    color = CustomTheme.colors.secondaryText
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${user.location!!.country}, ${user.location!!.city}",
                    color = CustomTheme.colors.secondaryText
                )
            }
        }
    }
}