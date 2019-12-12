package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 lateinit var  myData: MyDataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(MyDataModel::class.java)
        display()
        buttonCalculate.setOnClickListener {
            myData.totalPremium = cal()
            display()

        }

        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            textViewPremium.setText("")
            checkBoxSmoker.setChecked(false)
            myData.totalPremium = 0
        }

        

    }

    fun display() {
        if(myData.totalPremium != 0)
        textViewPremium.text = "Total Premium: Rm " + cal().toString()
    }

    fun cal(): Int {
        val age = spinnerAge.selectedItemPosition;
        val female = radioButtonFemale.isChecked;
        val male = radioButtonMale.isChecked
        var total = 0;
        when{
            age == 0 -> {total = 60}
            age == 1 && !checkBoxSmoker.isChecked-> {total = 70}
            age == 1 && female && checkBoxSmoker.isChecked -> {total = 170}
            age == 1 && male && checkBoxSmoker.isChecked -> {total = 120}
            age == 2 && !checkBoxSmoker.isChecked-> {total = 90}
            age == 2 && female && checkBoxSmoker.isChecked -> {total = 240}
            age == 2 && male && checkBoxSmoker.isChecked -> {total = 190}
            age == 3 && !checkBoxSmoker.isChecked-> {total = 120}
            age == 3 && female && checkBoxSmoker.isChecked -> {total = 320}
            age == 3 && male && checkBoxSmoker.isChecked -> {total = 270}
            age == 4 && !checkBoxSmoker.isChecked-> {total = 150}
            age == 4 && female && checkBoxSmoker.isChecked -> {total = 400}
            age == 4 && male && checkBoxSmoker.isChecked -> {total = 350}
            age == 5 && !checkBoxSmoker.isChecked -> {total = 150}
            age == 5 && female && checkBoxSmoker.isChecked -> {total = 450}
            age == 5 && male && checkBoxSmoker.isChecked -> {total = 350}

        }
        return total

    }
}
