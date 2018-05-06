package com.example.josephsouthern.truckingcost

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_load_calculator.*
import kotlinx.android.synthetic.main.fragment_load_calculator.*
import kotlinx.android.synthetic.main.fragment_load_calculator.view.*

class LoadCalculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_calculator)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()



            var miles: Long = 0.0.toLong()
            var weight: Long = 0.0.toLong()

            if (!editMiles.text.toString().isEmpty()) {
                miles = editMiles.text.toString().toLong()
            }
            if (!editWeight.text.toString().isEmpty()) {
                weight = editWeight.text.toString().toLong()
            }


            var price = (miles * 3.00)

            if (weight > 500.00 && !switchTrailerProvided.isChecked) {
                price = price * 1.1
            }

            finalPrice.text = "$" + "%.2f".format(price).toString()

        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_load_calculator, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
