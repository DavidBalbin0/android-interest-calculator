package david.balbino.interestcalculator.interest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import david.balbino.interestcalculator.calculateAmount
import david.balbino.interestcalculator.calculateInterest
import david.balbino.interestcalculator.components.InputField
import david.balbino.interestcalculator.components.PrimaryButton
import david.balbino.interestcalculator.components.ResultCard

@Composable
fun InterestScreen(
    interestScreenViewModel: InterestScreenViewModel
) {

    // Observe ViewModel values for dynamic updates
    val principal by interestScreenViewModel.principal.observeAsState(initial = "")
    val rate by interestScreenViewModel.rate.observeAsState(initial = "")
    val period by interestScreenViewModel.period.observeAsState(initial = "")
    val interest by interestScreenViewModel.interest.observeAsState(initial = 0.0)
    val amount by interestScreenViewModel.amount.observeAsState(initial = 0.0)

    // Main layout of the interest calculation screen
    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Simple interest calculation",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Data entry form
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Investment Data",
                        fontWeight = FontWeight.Bold
                    )
                    // Application's input fields
                    InputField(
                        label = "investment value",
                        placeholder = "How much do you wish to invest?",
                        value = principal,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        updateValue = { interestScreenViewModel.onPrincipalChanged(it) }
                    )
                    InputField(
                        label = "Monthly interest rate",
                        placeholder = "What is the monthly interest rate?",
                        value = rate,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        updateValue = { interestScreenViewModel.onRateChanged(it) }
                    )
                    InputField(
                        label = "Time period in months",
                        placeholder = "What is the time in months?",
                        value = period,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        updateValue = { interestScreenViewModel.onPeriodChanged(it) }
                    )
                    PrimaryButton(
                        text = "CALCULATE",
                        onClick = {
                            interestScreenViewModel.calculateInterestViewModel()
                            interestScreenViewModel.calculateAmountViewModel()
                        },
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Calculation result
            ResultCard(interest = interest, amount = amount)
        }
    }
}