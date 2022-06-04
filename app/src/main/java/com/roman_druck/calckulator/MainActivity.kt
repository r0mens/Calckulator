package com.roman_druck.calckulator

//import android.view.KeyEvent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

//import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {
    lateinit var pantone : AutoCompleteTextView
    var colorsampl : TextView? = null
    lateinit var massa : EditText
    lateinit var basecolor1 : EditText
    lateinit var basecolor2 : EditText
    var basecolor3 : EditText? =  null
    var basecolor4 : EditText? = null
    lateinit var percent1 : EditText
    lateinit var percent2 : EditText
    var percent3 : EditText? = null
    var percent4 : EditText? = null

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
        //val namecolor = resources.getStringArray(R.array.color_name_array)
        val hexcodes = resources.getStringArray(R.array.color_array)

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
            //basecolor1.add(tokens[1])

            //Log.d(TAG, "colorName: ${tokens[0]}")



        }


        //use array of string to populate a spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, colorName)
        pantone.setAdapter(adapter)
        pantone.threshold = 3

        // when item chosen in spinner display same thing in textview
        pantone.setOnItemClickListener { adapterView, view, i, l ->
            //override fun onItemClickListener(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {}

            Toast.makeText(applicationContext, pantone.text.toString(), Toast.LENGTH_SHORT).show()
            try {
                //colorsampl.visibility = TextView.VISIBLE

                massa.setBackgroundColor(Color.parseColor(pantone.text.toString()))
            } catch (e: Exception) {
                val index = colorName.indexOf(pantone.text.toString())
                //Log.d(TAG,"colorName: $colorName")
                //colorName.forEach { i ->}
                //split/parse the ith line into tokens
                val tokens = lines[index].split("|")
                Log.d(TAG,"tokens :$tokens")

                val item = tokens.size
                Log.d(TAG, "item :$item")
                tokens.forEach{



                    if(item <= 5 ){
                             basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[1])
                             basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[3])
                             percent1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                             percent2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                             colorsampl?.visibility = View.VISIBLE
                             colorsampl?.setBackgroundColor(Color.parseColor(hexcodes[index]))
                             Log.d(TAG,"newEditable :${tokens[1]}")
                             Log.d(TAG,"newEditable :${tokens[2]}")
                             Log.d(TAG,"newEditable :${tokens[3]}")
                             Log.d(TAG,"newEditable :${tokens[4]}")

                    }
                    if (item >=7){
                        basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[1])
                        basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[3])
                        percent1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                        percent2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                        basecolor3?.text = Editable.Factory.getInstance().newEditable(tokens[5])
                        percent3?.text = Editable.Factory.getInstance().newEditable(tokens[6])
                        colorsampl?.visibility = View.VISIBLE
                        colorsampl?.setBackgroundColor(Color.parseColor(hexcodes[index]))
                    }
                     else{
                        basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[1])
                        basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[3])
                        percent1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                        percent2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                        basecolor3?.text = Editable.Factory.getInstance().newEditable(tokens[5])
                        percent3?.text = Editable.Factory.getInstance().newEditable(tokens[6])
                        basecolor4?.text = Editable.Factory.getInstance().newEditable(tokens[7])
                        percent4?.text = Editable.Factory.getInstance().newEditable(tokens[8])
                        colorsampl?.visibility = View.VISIBLE
                        colorsampl?.setBackgroundColor(Color.parseColor(hexcodes[index]))
                    }
                    //basecolor1.setTextColor(Color.parseColor(Constans.Yellow))


                    //basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[3])
                    //basecolor2.setTextColor(Color.parseColor(Constans.WarmRed))
                    Log.d(TAG,"newEditable :${tokens[3]}")
                    //percent1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                    Log.d(TAG,"newEditable :${tokens[2]}")
                   //percent2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                    Log.d(TAG,"newEditable :${tokens[4]}")
                   // basecolor3?.text = Editable.Factory.getInstance().newEditable(tokens[5])
                    //basecolor3.setTextColor(Color.parseColor(Constans.ReflexBlue)
                    Log.d(TAG,"newEditable :${tokens[5]}")
                    basecolor4?.text = Editable.Factory.getInstance().newEditable(tokens[7])
                    //basecolor4.setTextColor(Color.parseColor(Constans.Black))
                    Log.d(TAG,"newEditable :${tokens[7]}")
                    //percent3?.text = Editable.Factory.getInstance().newEditable(tokens[6])
                    Log.d(TAG,"newEditable :${tokens[6]}")
                    percent4?.text = Editable.Factory.getInstance().newEditable(tokens[8])
                    Log.d(TAG,"newEditable :${tokens[8]}")
                }


                //val index = colorNames.indexOf(pantone.text.toString())
                Toast.makeText(applicationContext, "" , Toast.LENGTH_SHORT).show()
                colorsampl?.visibility = View.VISIBLE
                colorsampl?.setBackgroundColor(Color.parseColor(hexcodes[index]))


            }
        }
        magenta.setOnClickListener {

            val mp = MediaPlayer.create(baseContext, R.raw.ortal_combat_toasty)
            mp.start()
            magenta.isEnabled = false
            mp.setOnCompletionListener {
                magenta.isEnabled = true


            }

           // Toast.makeText(
                //this,
                //R.string.tost,
                //Toast.LENGTH_SHORT)
                //.show()

        }
        //fun setColorText() {
           // val

    }

}



// "color", getPackageName())


                // display color info
               // basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
               // basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
               // basecolor3.text = Editable.Factory.getInstance().newEditable(tokens[6])
               // percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
               // percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
               // percent3.text = Editable.Factory.getInstance().newEditable(tokens[7])
               // basecolor4.text = Editable.Factory.getInstance().newEditable(tokens[8])
                //percent4.text = Editable.Factory.getInstance().newEditable(tokens[9])



            //override fun onNothingSelected(adapterView: AdapterView<*>) {}
        //end onItemSelectedListener

     //end onCreate
 //end MainActivity




