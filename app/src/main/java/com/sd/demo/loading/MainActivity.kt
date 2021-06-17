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
                // 设置是否拦截事件
                _binding.viewLoading.setConsumeTouchEvent(true)
                // 设置内容区域背景
                _binding.viewLoading.setContentBackgroundResource(R.drawable.lib_loading_bg_content)
                // 设置文字
                _binding.viewLoading.setText("loading")
                _binding.viewLoading.visibility = View.VISIBLE
                v.postDelayed({ _binding.viewLoading.visibility = View.GONE }, 5000)
            }
        }
    }
}