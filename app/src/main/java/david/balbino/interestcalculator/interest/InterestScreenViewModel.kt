package david.balbino.interestcalculator.interest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import david.balbino.interestcalculator.calculateAmount
import david.balbino.interestcalculator.calculateInterest

class InterestScreenViewModel : ViewModel() {

    // LiveData objects to hold input values and calculated results
    private val _principal = MutableLiveData<String>()
    val principal: LiveData<String> = _principal

    private val _rate = MutableLiveData<String>()
    val rate: LiveData<String> = _rate

    private val _period = MutableLiveData<String>()
    val period: LiveData<String> = _period


    private val _interest = MutableLiveData<Double>()
    val interest: LiveData<Double> = _interest

    private val _amount = MutableLiveData<Double>()
    val amount: LiveData<Double> = _amount

    // Functions to update input values
    fun onPrincipalChanged(newPrincipal: String) {
        _principal.value = newPrincipal
    }

    fun onRateChanged(newRate: String) {
        _rate.value = newRate
    }

    fun onPeriodChanged(newPeriod: String) {
        _period.value = newPeriod
    }

    // Function to calculate interest based on input values
    fun calculateInterestViewModel() {
        _interest.value = calculateInterest(
            principal = _principal.value!!.toDouble(),
            rate = _rate.value!!.toDouble(),
            months = _period.value!!.toDouble(),
        )
    }

    // Function to calculate total amount based on input values
    fun calculateAmountViewModel(){
        _amount.value = calculateAmount(
            principal = _principal.value!!.toDouble(),
            interest = _interest.value!!
        )
    }

}