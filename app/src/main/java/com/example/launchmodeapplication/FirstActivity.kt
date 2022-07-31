package com.example.launchmodeapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.launchmodeapplication.databinding.ActivityMainBinding

class FirstActivity : BaseActivity(), View.OnClickListener {

    private val TAG: String = FirstActivity::class.java.getSimpleName()
    private var instanceCounter = 0
    private var currentInstanceValue = 0

    private lateinit var binding: ActivityMainBinding

    fun constructor1() {
        instanceCounter++
        currentInstanceValue = instanceCounter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("poppers", "First")
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.button -> {
                startActivity(this, FirstActivity::class.java)
            }
            binding.button2 -> {
                startActivity(this, SecondActivity::class.java)
            }
            binding.button3 -> {
                startActivity(this, ThirdActivity::class.java)
            }
            binding.button4 -> {
                startActivity(this, FourthActivity::class.java)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("taskChecker",appTaskState())
    }


}