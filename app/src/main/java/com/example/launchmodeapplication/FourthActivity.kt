package com.example.launchmodeapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.launchmodeapplication.databinding.ActivityFourthBinding

class FourthActivity : BaseActivity() , View.OnClickListener {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("poppers", "Fourth")
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.button->{
                startActivity(this,  FirstActivity::class.java)
            }
            binding.button2->{
                startActivity(this,  SecondActivity::class.java)
            }
            binding.button3->{
                startActivity(this,  ThirdActivity::class.java)
            }
            binding.button4->{
                startActivity(this,  FourthActivity::class.java)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("taskChecker",appTaskState())
    }

}