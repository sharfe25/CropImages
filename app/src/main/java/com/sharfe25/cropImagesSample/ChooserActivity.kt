package com.sharfe25.cropImagesSample

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.sharfe25.cropImagesSample.CropActivity.Companion.CIRCLE
import com.sharfe25.cropImagesSample.CropActivity.Companion.CUSTOM
import com.sharfe25.cropImagesSample.CropActivity.Companion.EXTRA_SHAPE_TYPE
import com.sharfe25.cropImagesSample.CropActivity.Companion.RECTANGLE

class ChooserActivity : AppCompatActivity(R.layout.activity_chooser) {

  private val samples: Array<String> = arrayOf(RECTANGLE, CIRCLE, CUSTOM)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val listView = findViewById<ListView>(R.id.sample_list)
    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, samples)
    listView.adapter = adapter
    listView.setOnItemClickListener { _, _, position, _ ->
      val intent = Intent(this, CropActivity::class.java)
      intent.putExtra(EXTRA_SHAPE_TYPE, samples[position])
      startActivity(intent)
    }
  }
}
