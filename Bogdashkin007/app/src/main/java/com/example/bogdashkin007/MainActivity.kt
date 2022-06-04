package com.example.bogdashkin007

/*
    Read text file into list of strings
    parse/split elements to make array to load spinner
    split the "ith" on the fly to display info
    about the dog selected by the user with the spinner
*/

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val spDogData = findViewById<Spinner>(R.id.spDogData)
        //val ivDog = findViewById<ImageView>(R.id.ivDog)
        //val tvDogHeight = findViewById<TextView>(R.id.tvDogHeight)
        //val tvDogColor = findViewById<TextView>(R.id.tvDogColor)
        //val tvDogChar = findViewById<TextView>(R.id.tvDogChar)
        val pantone = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val colorsampl = findViewById<View>(R.id.colorsampl)
        val basecolor1 = findViewById<EditText>(R.id.basecolor1)
        val basecolor2 = findViewById<EditText>(R.id.basecolor2)
        val basecolor3 = findViewById<EditText>(R.id.basecolor3)
        //val basecolor4 = findViewById<EditText>(R.id.basecolor4)
        val percent1 = findViewById<EditText>(R.id.percent1)
        val percent2 = findViewById<EditText>(R.id.percent2)
        val percent3 = findViewById<EditText>(R.id.percent3)
       //val percent4 = findViewById<EditText>(R.id.percent4)
        val namecolor = resources.getStringArray(R.array.color_name_array)

        val input_stream = baseContext.resources.openRawResource(R.raw.pantone_data)
        // create a BufferedeReader from the input stream in order to read line-by-line
        val buffer = input_stream.bufferedReader()

        val lines = buffer.readLines() // creates a List of strings
        val colorNames: MutableList<String> = ArrayList()

        // create list of dognames to populate spinner
        for (item in lines) {
            val tokens = item.split("|")
            colorNames.add(tokens[0])

        }

        //use array of string to populate a spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colorNames)
        // aaDogData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // The drop down view
        pantone.setAdapter(adapter)
        pantone.threshold = 3

        // when item chosen in spinner display same thing in textview
        pantone.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val tvUserItem = view as TextView
                Toast.makeText(applicationContext,
                    "You chose " + tvUserItem.text.toString(),
                    Toast.LENGTH_SHORT).show()

                // split/parse the ith line into tokens
                val tokens = lines[i].split("|")

                // turn dogname into drawable resource name
                var pantone_name = tokens[0]

                //get the id from the resource name
                val pantone = getResources().getIdentifier(pantone_name, "colors", getPackageName())
                colorsampl.visibility = View.VISIBLE
                colorsampl.setBackgroundColor(Color.parseColor(colorNames[1]))

                // display dog breed info
                basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                basecolor3.text = Editable.Factory.getInstance().newEditable(tokens[6])
                percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
                percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
                percent3.text = Editable.Factory.getInstance().newEditable(tokens[7])
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }//end onItemSelectedListener

    } //end onCreate

} //end MainActivity