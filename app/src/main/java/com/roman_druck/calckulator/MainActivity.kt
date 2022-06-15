package com.roman_druck.calckulator


import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
//import java.math.BigDecimal
//import java.math.RoundingMode
//import java.text.DecimalFormat
//import kotlin.math.round
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    lateinit var pantone : AutoCompleteTextView
    private var colorsampl : TextView? = null
    lateinit var massa : EditText
    lateinit var basecolor1 : EditText
    lateinit var basecolor2 : EditText
    lateinit var basecolor3 : EditText
    lateinit var basecolor4 : EditText
    lateinit var percent1 : EditText
    lateinit var percent2 : EditText
    lateinit var percent3 : EditText
    lateinit var percent4 : EditText
    lateinit var weightcolor1 : EditText
    lateinit var weightcolor2 : EditText
    lateinit var weightcolor3 : EditText
    lateinit var weightcolor4 : EditText

    val TAG : String = "Main"

    //val hex_pattern = Regex("^#[0-9A-F]{6}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pantone = findViewById(R.id.autoCompleteTextView)
        colorsampl = findViewById(R.id.colorsampl)
        massa = findViewById(R.id.massa)
        basecolor1 = findViewById(R.id.basecolor1)
        basecolor2 = findViewById(R.id.basecolor2)
        basecolor3 = findViewById(R.id.basecolor3)
        basecolor4 = findViewById(R.id.basecolor4)
        percent1 = findViewById(R.id.percent1)
        percent2 = findViewById(R.id.percent2)
        percent3 = findViewById(R.id.percent3)
        percent4 = findViewById(R.id.percent4)
        val magenta = findViewById<Button>(R.id.button2)
        val kkalkulat = findViewById<Button>(R.id.button4)
        weightcolor1 = findViewById(R.id.weightcolor1)
        weightcolor2 = findViewById(R.id.weightcolor2)
        weightcolor3 = findViewById(R.id.weightcolor3)
        weightcolor4 = findViewById(R.id.weightcolor4)

        val input_stream = baseContext.resources.openRawResource(R.raw.pantone_data)
        // create a BufferedeReader from the input stream in order to read line-by-line
        val buffer = input_stream.bufferedReader()
        //Log.d(TAG, "buffer: $buffer")

        val lines = buffer.readLines()// creates a List of strings
        //Log.d(TAG, "lines: $lines")
        val colorName: MutableList<String> = ArrayList()
        //Log.d(TAG,"colorName: $colorName")

        // create list of colornames to populate spinner
        for (i in lines) {
            val tokens = i.split("|")
            //Log.d(TAG, "tokens: ${i.split("|")}")
            colorName.add(tokens[0])

            //Log.d(TAG, "colorName: ${tokens[0]}")


        }


        //use array of string to populate a spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colorName)
        pantone.setAdapter(adapter)
        pantone.threshold = 3

        // when item chosen in spinner display same thing in textview
        pantone.setOnItemClickListener { adapterView, view, i, l ->


            Toast.makeText(applicationContext, pantone.text.toString(), Toast.LENGTH_SHORT).show()
            try {
                colorsampl?.visibility = TextView.VISIBLE
                massa.setBackgroundColor(Color.parseColor(pantone.text.toString()))
            } catch (e: Exception) {
                val index = colorName.indexOf(pantone.text.toString())
                Log.d(TAG, "colorName: $colorName")

                //split/parse the ith line into tokens
                val tokens = lines[index].split("|")
                Log.d(TAG, "tokens :$tokens")

                var item = tokens.size
                Log.d(TAG, "item :$item")

                for (i in tokens) {

                    Log.d(TAG, "i :$i")
                    when (item) {
                        6 -> {
                            basecolor1.getText().clear()
                            basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                            basecolor2.getText().clear()
                            basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                            percent1.getText().clear()
                            percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
                            percent2.getText().clear()
                            percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
                            basecolor3.getText().clear()
                            basecolor4.getText().clear()
                            percent3.getText().clear()
                            percent4.getText().clear()
                            weightcolor1.getText().clear()
                            weightcolor2.getText().clear()
                            weightcolor3.getText().clear()
                            weightcolor4.getText().clear()
                            calculateTip()

                        }
                        8 -> {
                            basecolor1.getText().clear()
                            basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                            basecolor2.getText().clear()
                            basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                            percent1.getText().clear()
                            percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
                            percent2.getText().clear()
                            percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
                            basecolor3.getText().clear()
                            basecolor3.text = Editable.Factory.getInstance().newEditable(tokens[6])
                            percent3.getText().clear()
                            percent3.text = Editable.Factory.getInstance().newEditable(tokens[7])
                            basecolor4.getText().clear()
                            percent4.getText().clear()
                            weightcolor1.getText().clear()
                            weightcolor2.getText().clear()
                            weightcolor3.getText().clear()
                            weightcolor4.getText().clear()
                            calculateTip()
                        }
                        10 -> {
                            basecolor1.getText().clear()
                            basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                            basecolor2.getText().clear()
                            basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                            percent1.getText().clear()
                            percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
                            percent2.getText().clear()
                            percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
                            basecolor3.getText().clear()
                            basecolor3.text = Editable.Factory.getInstance().newEditable(tokens[6])
                            percent3.getText().clear()
                            percent3.text = Editable.Factory.getInstance().newEditable(tokens[7])
                            basecolor4.getText().clear()
                            basecolor4.text = Editable.Factory.getInstance().newEditable(tokens[8])
                            percent4.getText().clear()
                            percent4.text = Editable.Factory.getInstance().newEditable(tokens[9])
                            weightcolor1.getText().clear()
                            weightcolor2.getText().clear()
                            weightcolor3.getText().clear()
                            weightcolor4.getText().clear()
                            calculateTip()

                        }

                    }


                }


                //Toast.makeText(applicationContext, "" , Toast.LENGTH_SHORT).show()
                colorsampl?.visibility = View.VISIBLE
                colorsampl?.setBackgroundColor(Color.parseColor(tokens[1]))


            }
        }
        magenta.setOnClickListener {

            val mp = MediaPlayer.create(baseContext, R.raw.ortal_combat_toasty)
            mp.start()
            magenta.isEnabled = false
            mp.setOnCompletionListener {
                magenta.isEnabled = true


            }

        }
        kkalkulat.setOnClickListener() {
           calculateTip()
        }
    }
        fun calculateTip() {
            if (TextUtils.isEmpty(massa.text.toString())) {
                massa.error = "Количество краски в десятичной дроби"
                return
            }
            if (TextUtils.isEmpty(percent3.text.toString())) {
                percent3.error = "Введите проценты"
                return
            }
            if (TextUtils.isEmpty(percent4.text.toString())) {
                percent4.error = "Введите проценты"
                return
            }


            val doubleMassa = massa.text.toString().toDouble()
            val tipPercent1 = percent1.text.toString().toDouble()
            val tipPercent2 = percent2.text.toString().toDouble()
            val tipPercent3 = percent3.text.toString().toDouble()
            val tipPercent4 = percent4.text.toString().toDouble()



            val calc_tip1 = ((doubleMassa * tipPercent1) / 100 * 100).roundToInt()/100.0
            val calc_tip2 = ((doubleMassa * tipPercent2) / 100 * 100).roundToInt()/100.0
            val calc_tip3 = ((doubleMassa * tipPercent3) / 100 * 100).roundToInt()/100.0
            val calc_tip4 = ((doubleMassa * tipPercent4) / 100 * 100).roundToInt()/100.0
            weightcolor1.text = Editable.Factory.getInstance().newEditable(calc_tip1.toString())
            weightcolor2.text = Editable.Factory.getInstance().newEditable(calc_tip2.toString())
            weightcolor3.text = Editable.Factory.getInstance().newEditable(calc_tip3.toString())
            weightcolor4.text = Editable.Factory.getInstance().newEditable(calc_tip4.toString())
            //Log.d(TAG, "calc_tip1: $calc_tip1")
            //Log.d(TAG, "calc_tip2: $calc_tip2")
            //Log.d(TAG, "calc_tip3: $calc_tip3")
            //Log.d(TAG, "calc_tip4: $calc_tip4")
            Log.d(TAG, "weightcolor1: ${weightcolor1.text}")
            Log.d(TAG, "weightcolor2: ${weightcolor2.text}")
            Log.d(TAG, "weightcolor3: ${weightcolor3.text}")
            Log.d(TAG, "weightcolor4: ${weightcolor4.text}")


        }

}













