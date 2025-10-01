package pe.edu.upc.easyshop.features.home.presentation.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import pe.edu.upc.easyshop.core.ui.components.RoundedIcon

@Composable
fun ProductDetail(viewModel: ProductDetailViewModel = hiltViewModel()) {
      val product = viewModel.product.collectAsState()
      product.value?.let { product ->
          Scaffold(
              floatingActionButton = {
                  FloatingActionButton(
                      onClick = {

                      }) {
                      Text("Add to cart")
                  }
              },
              floatingActionButtonPosition = FabPosition.Center

          ) { paddingValues ->
              Column(modifier = Modifier.padding(paddingValues)) {
                  AsyncImage(
                      product.image,
                      contentDescription = null,
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(256.dp),
                      contentScale = ContentScale.FillHeight
                  )
                  Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                      Text(
                          product.name,
                          style = MaterialTheme.typography.headlineSmall
                      )
                      Text(
                          "%.2f".format(product.price),
                          style = MaterialTheme.typography.headlineSmall
                      )
                  }
                  Row (verticalAlignment = Alignment.CenterVertically) {
                      RoundedIcon(Icons.Default.Remove)
                      Text("1", modifier = Modifier.padding(8.dp))
                      RoundedIcon(Icons.Default.Add)
                  }
              }

          }
      }



}