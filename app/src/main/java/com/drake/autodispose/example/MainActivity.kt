package com.drake.autodispose.example

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.drake.autodispose.auto
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.startInterval()

        Observable.interval(1, TimeUnit.SECONDS).auto(this, Lifecycle.Event.ON_PAUSE).subscribe {
            Log.d("日志", "MainActivity = $it")
        }

    }
}
