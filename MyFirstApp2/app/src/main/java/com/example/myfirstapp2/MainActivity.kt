package com.example.myfirstapp2

/*
    Read text file into list of strings
    parse/split elements to make array to load spinner
    split the "ith" on the fly to display info
    about the dog selected by the user with the spinner
*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pantone = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val colorsampl = findViewById<ImageView>(R.id.colorsampl)
        val basecolor1 = findViewById<EditText>(R.id.basecolor1)
        val basecolor2 = findViewById<EditText>(R.id.basecolor2)
        val basecolor3 = findViewById<EditText>(R.id.basecolor3)
        val basecolor4 = findViewById<EditText>(R.id.basecolor4)
        val percent1 = findViewById<EditText>(R.id.percent1)
        val percent2 = findViewById<EditText>(R.id.percent2)
        val percent3 = findViewById<EditText>(R.id.percent3)
        val percent4 = findViewById<EditText>(R.id.percent4)
        val colorNames = arrayOf<String>("p_100", "p_101", "p_102", "p_103", "p_104",
                                         "p_105", "p_106", "p_107", "p_108", "p_109")


        val input_stream = baseContext.resources.openRawResource(R.raw.pantone_data)
        // create a BufferedeReader from the input stream in order to read line-by-line
        val buffer = input_stream.bufferedReader()

        val lines = buffer.readLines() // creates a List of strings
        var colorName: MutableList<String> = ArrayList()

        // create list of dognames to populate spinner
        for(item in lines){
            val tokens = item.split("|")
            colorName.add(tokens[0])
        }

        //use array of string to populate a spinner
        val colorAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colorNames)
        // aaDogData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // The drop down view
        pantone.setAdapter(colorAdapter)
        pantone.setThreshold(3)

        // when item chosen in spinner display same thing in textview
        pantone.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val tvUserItem = view as TextView
                Toast.makeText(applicationContext, "You chose " + tvUserItem.text.toString(), Toast.LENGTH_SHORT).show()

                // split/parse the ith line into tokens
                val tokens = lines[i].split("|")

                // turn dogname into drawable resource name
                var drawable_resource_name = tokens[0].lowercase().replace(" ", "_")


                //get the id from the resource name
                val drawable_resouce_id = getResources().getIdentifier(drawable_resource_name,
                    "drawable",
                    getPackageName())
                colorsampl.setImageResource(drawable_resouce_id)



                // display dog breed info
                // display dog breed info
                basecolor1.text = Editable.Factory.getInstance().newEditable(tokens[2])
                basecolor2.text = Editable.Factory.getInstance().newEditable(tokens[4])
                basecolor3.text = Editable.Factory.getInstance().newEditable(tokens[6])
                percent1.text = Editable.Factory.getInstance().newEditable(tokens[3])
                percent2.text = Editable.Factory.getInstance().newEditable(tokens[5])
                percent3.text = Editable.Factory.getInstance().newEditable(tokens[7])
                basecolor4.text = Editable.Factory.getInstance().newEditable(tokens[8])
                percent4.text = Editable.Factory.getInstance().newEditable(tokens[9])
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }//end onItemSelectedListener

    } //end onCreate
} //end MainActivity

