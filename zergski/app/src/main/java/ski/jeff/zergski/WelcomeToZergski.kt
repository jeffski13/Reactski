package ski.jeff.zergski

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeToZergski() {
    var shouldShowWelcomeToZergski by remember {
        mutableStateOf(true)
    }
    Image(painter = painterResource(id = R.drawable.homescreen), contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
        )
    Column(
        modifier = Modifier.border(5.dp, Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Spacer(modifier = Modifier.padding(0.dp, 5.dp))
        Text("Howdy. this is Zergski", color = Color.White)
        Spacer(modifier = Modifier.padding(0.dp, 80.dp))
        Button(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            onClick = {shouldShowWelcomeToZergski = false}) {
            Text("Start", modifier = Modifier
                .padding(110.dp,5.dp))
        }
    }
}

@PreviewScreenSizes
@Composable
fun showWelcomeToZergski() {
    WelcomeToZergski()
}