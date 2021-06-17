package com.sd.demo.loading

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.loading.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val size = resources.displayMetrics.density * 15
        _binding.viewLoading.setProgressSize(size.toInt())
    }

    override fun onClick(v: View) {
        when (v) {
            _binding.btn -> {
                Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
                _binding.viewLoading.setConsumeTouchEvent(true)
                _binding.viewLoading.visibility = View.VISIBLE
                v.postDelayed({ _binding.viewLoading.visibility = View.GONE }, 5000)
            }
        }
    }
}