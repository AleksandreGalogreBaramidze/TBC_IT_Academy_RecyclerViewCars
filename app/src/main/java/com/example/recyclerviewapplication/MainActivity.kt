package com.example.recyclerviewapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private val viewItems = mutableListOf<Items>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        addData()
    }

    private fun init(){
        adapter = RecyclerViewAdapter(viewItems)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        binding.startRaceButton.setOnClickListener{
            val intent = Intent(this, WelcomeScreen::class.java)
            startActivity(intent)
        }
    }

    private fun addData(){
        val speed = "Speed:"
        val type = "Type:"
        viewItems.add(Items(R.drawable.ic_sedan, "$speed Sedan", "$type Fast",
            R.drawable.ic_supercharger_engine
        ))
        viewItems.add(Items(R.drawable.ic_automobile_orange, "$speed Coupe", "$type Fast",
            R.drawable.ic_v8_engine
        ))
        viewItems.add(Items(R.drawable.ic_hatchback, "$speed HatchBack", "$type Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_automobile_green, "$speed SUV", "$type Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_supercar, "$speed SuperCar", "$type Super Fast",
            R.drawable.ic_v8_engine
        ))
        viewItems.add(Items(R.drawable.ic_suv_blue, "$speed SUV", "$type Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_cabrio, "$speed Cabrio", "$type Fast",
            R.drawable.ic_electro_engine
        ))
        viewItems.add(Items(R.drawable.ic_motor_sports, "$speed MotorCircle", "$type Medium",
            R.drawable.ic_supercharger_engine
        ))
        adapter.notifyDataSetChanged()
    }
}