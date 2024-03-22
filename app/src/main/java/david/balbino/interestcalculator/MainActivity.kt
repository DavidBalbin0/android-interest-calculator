package david.balbino.interestcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import david.balbino.interestcalculator.ui.theme.InterestCalculatorTheme
import david.balbino.interestcalculator.interest.InterestScreen
import david.balbino.interestcalculator.interest.InterestScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterestCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InterestScreen(InterestScreenViewModel())
                }
            }
        }
    }
}
