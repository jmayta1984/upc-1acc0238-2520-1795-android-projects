package pe.edu.upc.easyshop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyshop.ui.theme.EasyShopTheme

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            WidthSpacer()
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Hello Alex",
                )
                Text(
                    "Good morning!",
                    fontWeight = FontWeight.SemiBold
                )
            }
            WidthSpacer()
            RoundedIcon(Icons.Outlined.Notifications)
            WidthSpacer()
            RoundedIcon(Icons.Outlined.ShoppingCart)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                },
                placeholder = { Text("Search") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp)
            )
            WidthSpacer()
            RoundedIcon(Icons.Outlined.FilterList)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                "Categories",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = {}) { Text("See all") }
        }
    }
}

@Composable
fun WidthSpacer() {
    Spacer(modifier = Modifier.width(8.dp))
}

@Composable
fun RoundedIcon(icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    EasyShopTheme {
        Home()
    }
}