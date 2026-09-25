package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.model.Restaurant
import com.example.ui.theme.Gray200
import com.example.ui.theme.Gray300
import com.example.ui.theme.Gray500
import com.example.ui.theme.Gray700
import com.example.ui.theme.ZomatoGold
import com.example.ui.theme.ZomatoGoldLight
import com.example.ui.theme.ZomatoRed
import com.example.ui.theme.ZomatoRedLight

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookTableDialog(
    restaurant: Restaurant,
    onDismiss: () -> Unit,
    onConfirm: (date: String, timeSlot: String, guests: Int, specialRequest: String) -> Unit
) {
    var selectedDate by remember { mutableStateOf("Today, 25 Sep") }
    var selectedTime by remember { mutableStateOf("8:00 PM") }
    var guestsCount by remember { mutableIntStateOf(2) }
    var selectedRequest by remember { mutableStateOf("Window Table") }

    val dates = listOf("Today, 25 Sep", "Tomorrow, 26 Sep", "Sat, 27 Sep")
    val times = listOf("7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM")
    val requests = listOf("Window Table", "Anniversary", "Quiet Area", "Birthday Party")

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .testTag("book_table_dialog"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Reserve a Table",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = restaurant.name,
                            fontSize = 13.sp,
                            color = ZomatoRed,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Date Selection
                Text(
                    text = "SELECT DATE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray700
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    dates.forEach { date ->
                        val isSelected = selectedDate == date
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) ZomatoRed else Color.Transparent,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) ZomatoRed else Gray300
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedDate = date }
                        ) {
                            Text(
                                text = date,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(vertical = 8.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Time Slots
                Text(
                    text = "SELECT TIME SLOT",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray700
                )
                Spacer(modifier = Modifier.height(6.dp))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    times.forEach { time ->
                        val isSelected = selectedTime == time
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) ZomatoRedLight else Color.Transparent,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) ZomatoRed else Gray300
                            ),
                            modifier = Modifier.clickable { selectedTime = time }
                        ) {
                            Text(
                                text = time,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) ZomatoRed else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Number of Guests
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "NUMBER OF GUESTS",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Gray700
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = { if (guestsCount > 1) guestsCount-- },
                            modifier = Modifier
                                .size(32.dp)
                                .border(1.dp, Gray300, CircleShape)
                        ) {
                            Icon(imageVector = Icons.Filled.Remove, contentDescription = "Decrease", modifier = Modifier.size(16.dp))
                        }
                        Text(
                            text = "$guestsCount Guests",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                        IconButton(
                            onClick = { if (guestsCount < 12) guestsCount++ },
                            modifier = Modifier
                                .size(32.dp)
                                .border(1.dp, Gray300, CircleShape)
                        ) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase", modifier = Modifier.size(16.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Special Request
                Text(
                    text = "SEATING PREFERENCE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Gray700
                )
                Spacer(modifier = Modifier.height(6.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    requests.forEach { req ->
                        val isSelected = selectedRequest == req
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSelected) ZomatoRedLight else Color.Transparent,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) ZomatoRed else Gray300
                            ),
                            modifier = Modifier.clickable { selectedRequest = req }
                        ) {
                            Text(
                                text = req,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) ZomatoRed else Gray700,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Confirm Button
                Button(
                    onClick = {
                        onConfirm(selectedDate, selectedTime, guestsCount, selectedRequest)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("confirm_table_booking_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = ZomatoRed),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Confirm Reservation",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
