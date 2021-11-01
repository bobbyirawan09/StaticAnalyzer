package com.bobby.analyzer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bobby.analyzer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbtnToNextPage.setOnClickListener {
            val intent = Intent(this, Class.forName("com.bobby.register.RegisterActivity"))
            startActivity(intent)
        }

        val nullable: String? = null
        println(nullable!!)
    }


}
