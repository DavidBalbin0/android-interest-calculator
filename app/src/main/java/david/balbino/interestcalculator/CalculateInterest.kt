package david.balbino.interestcalculator

// Function to calculate simple interest
fun calculateInterest(principal: Double, rate: Double, months: Double): Double {
    return principal * rate / 100 * months
}

// Function to calculate total amount including interest
fun calculateAmount(principal: Double, interest: Double): Double{
    return principal + interest
}