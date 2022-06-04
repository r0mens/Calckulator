package com.example.printingcolorist

import android.os.Bundle
import android.text.Editable.Factory
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.printingcolorist.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //val pantoneArray = resources.getStringArray(R.array.color_name_array)
        //val basecolor1  = binding.basecolor1.text.toString()
        //val basecolor2  = binding.basecolor2.text.toString()
        //val basecolor3  = binding.basecolor3.text.toString()
        //val basecolor4  = binding.basecolor4.text.toString()
        //var percent1 = binding.percent1.text.toString().toFloat()
        // val percent2 = binding.percent2.text.toString()
        //val percent3 = binding.percent3.text.toString()
        //val percent4 = binding.percent4.text.toString()
        // val weightcolor1  = binding.weightcolor1.text.toString().toDouble()
        // val weightcolor2  = binding.weightcolor2.text.toString().toDouble()
        //val weightcolor3  = binding.weightcolor3.text.toString().toDouble()
        //val weightcolor4  = binding.weightcolor4.text.toString().toDouble()
        //val massa  = binding.massa.text.toString().toDouble()
        //val buffer = pantoneArray.readLi


        binding.button.setOnClickListener {

            val resultValue = binding.showcolor1.text.toString()




            when (resultValue) {

                "100C" -> {
                    binding.basecolor2.text = Factory.getInstance().newEditable("Trans.White")
                    binding.percent1.text = Factory.getInstance().newEditable("3.1")
                    binding.percent2.text = Factory.getInstance().newEditable("96.9")
                    binding.basecolor1.text = Factory.getInstance().newEditable("Yellow")
                    binding.basecolor1.setBackgroundResource(R.color.pantone_Yellow)
                    binding.basecolor2.setBackgroundResource(R.color.pantone_TransWhite)
                    binding.colorsampl.visibility = View.VISIBLE
                    binding.colorsampl.setBackgroundResource(R.color.pantone_100c)

                }
                "101C" -> {
                    binding.basecolor2.text = Factory.getInstance().newEditable("Trans.White")
                    binding.percent1.text = Factory.getInstance().newEditable("12.5")
                    binding.percent2.text = Factory.getInstance().newEditable("87.5")
                    binding.basecolor1.text = Factory.getInstance().newEditable("Yellow")
                    binding.basecolor1.setBackgroundResource(R.color.pantone_Yellow)
                    binding.basecolor2.setBackgroundResource(R.color.pantone_TransWhite)
                    binding.colorsampl.visibility = View.VISIBLE
                    binding.colorsampl.setBackgroundResource(R.color.pantone_101c)
                }

                "102C" -> {
                    binding.basecolor2.text = Factory.getInstance().newEditable("Trans.White")
                    binding.percent1.text = Factory.getInstance().newEditable("50.0")
                    binding.percent2.text = Factory.getInstance().newEditable("50.0")
                    binding.basecolor1.text = Factory.getInstance().newEditable("Yellow")
                    binding.basecolor1.setBackgroundResource(R.color.pantone_Yellow)
                    binding.basecolor2.setBackgroundResource(R.color.pantone_TransWhite)
                    binding.colorsampl.visibility = View.VISIBLE
                    binding.colorsampl.setBackgroundResource(R.color.pantone_102c)

                }

                "103C" -> {
                    binding.basecolor2.text = Factory.getInstance().newEditable("Black")
                    binding.percent1.text = Factory.getInstance().newEditable("98.5")
                    binding.percent2.text = Factory.getInstance().newEditable("1.5")
                    binding.basecolor1.text = Factory.getInstance().newEditable("Yellow")
                    binding.basecolor1.setBackgroundResource(R.color.pantone_Yellow)
                    binding.basecolor2.setBackgroundResource(R.color.black)
                    binding.colorsampl.visibility = View.VISIBLE
                    binding.colorsampl.setBackgroundResource(R.color.pantone_103c)

                }

                "104C" -> {
                    binding.basecolor2.text = Factory.getInstance().newEditable("Black")
                    binding.percent1.text = Factory.getInstance().newEditable("94.1")
                    binding.percent2.text = Factory.getInstance().newEditable("5.9")
                    binding.basecolor1.text = Factory.getInstance().newEditable("Yellow")
                    binding.basecolor1.setBackgroundResource(R.color.pantone_Yellow)
                    binding.basecolor2.setBackgroundResource(R.color.black)
                    binding.colorsampl.visibility = View.VISIBLE
                    binding.colorsampl.setBackgroundResource(R.color.pantone_104c)

                }

                else -> {

                    binding.massa.text.toString()


                }

            }
        }
    }
}



