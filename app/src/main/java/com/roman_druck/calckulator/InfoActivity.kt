package com.roman_druck.calckulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this@InfoActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.help -> {
                supportFragmentManager
                    .beginTransaction()
                    .remove(Fragment(1))
                    .replace(R.id.place_holder, FragmentHelp.newInstance())
                    .commit()

            }
            R.id.donat ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder,FragmentDonat.newInstance())
                    .commit()
            }
            R.id.info ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder,InfoFragment.newInstance())
                    .commit()

            }
        }
        return true
    }


}