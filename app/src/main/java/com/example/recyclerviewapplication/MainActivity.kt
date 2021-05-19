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
        viewItems.add(Items(R.drawable.ic_sedan, "$type Sedan", "$speed Fast",
            R.drawable.ic_supercharger_engine
        ))
        viewItems.add(Items(R.drawable.ic_automobile_orange, "$type Coupe", "$speed Fast",
            R.drawable.ic_v8_engine
        ))
        viewItems.add(Items(R.drawable.ic_hatchback, "$type HatchBack", "$speed Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_automobile_green, "$type SUV", "$speed Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_supercar, "$type SuperCar", "$speed Super Fast",
            R.drawable.ic_v8_engine
        ))
        viewItems.add(Items(R.drawable.ic_suv_blue, "$type SUV", "$speed Slow",
            R.drawable.ic_4v_engine
        ))
        viewItems.add(Items(R.drawable.ic_cabrio, "$type Cabrio", "$speed Fast",
            R.drawable.ic_electro_engine
        ))
        viewItems.add(Items(R.drawable.ic_motor_sports, "$type MotorCircle", "$speed Medium",
            R.drawable.ic_supercharger_engine
        ))
        adapter.notifyDataSetChanged()
    }
}