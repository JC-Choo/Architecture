package dev.chu.architecture.kotlin.p87_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.chu.architecture.R
import kotlinx.android.synthetic.main.activity_sample.*

data class Sample(val str: String)

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val list : MutableList<Sample> = mutableListOf()

        for(i in 0 until 20) {
            list.add(Sample("$i 번째"))
        }

        val adapter = SampleAdapter(list)
        sample_rv.adapter = adapter
    }

}