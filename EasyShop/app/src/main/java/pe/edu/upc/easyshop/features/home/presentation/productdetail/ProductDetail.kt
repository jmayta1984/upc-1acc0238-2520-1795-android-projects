package pe.edu.upc.easyshop.features.home.presentation.productdetail

import android.util.Log
import androidx.compose.runtime.Composable

@Composable
fun ProductDetail(viewModel: ProductDetailViewModel) {
    Log.d("ProductDetail", viewModel.toString())

    /*

      val product = viewModel.product.collectAsState()

      product.value?.let { product ->
          Log.d("ProductDetail", product.id.toString())
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
                  Row {
                      RoundedIcon(Icons.Default.Remove)
                      Text("1")
                      RoundedIcon(Icons.Default.Add)
                  }
              }

          }
      }


     */
}