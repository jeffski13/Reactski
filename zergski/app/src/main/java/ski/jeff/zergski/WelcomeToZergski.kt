package ski.jeff.zergski

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeToZergski(onStartClicked: () -> Unit, startButtonSpaceFromTopOfScreen: Int = 70) {
    Image(painter = painterResource(id = R.drawable.homescreen), contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
        )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Spacer(modifier = Modifier.padding(0.dp, 5.dp))
        Text("Howdy. this is Zergski", color = Color.White, style = TextStyle(fontWeight = FontWeight.ExtraBold))
        Spacer(modifier = Modifier.padding(0.dp, startButtonSpaceFromTopOfScreen.dp))
        Button(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            onClick = onStartClicked) {
            Text("Start", modifier = Modifier
                .padding(110.dp,5.dp))
        }
    }
}

@PreviewScreenSizes
@Composable
fun showWelcomeToZergski() {
    WelcomeToZergski({},80)
}