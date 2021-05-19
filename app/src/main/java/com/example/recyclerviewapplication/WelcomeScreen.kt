package com.example.recyclerviewapplication

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.recyclerviewapplication.databinding.ActivityMainBinding
import com.example.recyclerviewapplication.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler()
        startMainActivity()
        startCarEngine()
    }
    fun raceCar(car: ImageView, Duration: Int){
        val animator = ObjectAnimator.ofFloat(car,  View.TRANSLATION_X, 2000f)
        animator.start()
        animator.duration = Duration.toLong()
    }
    fun startCarEngine(){
        raceCar(binding.hatchbackCar, 7000)
        raceCar(binding.superCar, 3000)
        raceCar(binding.caprioCar, 5000)
        raceCar(binding.coupeCar, 4500)
        raceCar(binding.suvCar, 8000)
        raceCar(binding.sedanCar, 4000)
        raceCar(binding.hatchBackCar2, 6500)
    }

    private fun startMainActivity(){
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        },5000)
    }
}