package com.example.preyanshjain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preyanshjain.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding : ActivityHomeScreenBinding
    private lateinit var placesArrayList : ArrayList<Places>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.i_1,R.drawable.i_2,R.drawable.i_3,R.drawable.i_4,
            R.drawable.i_5,R.drawable.i_6,R.drawable.i_7,R.drawable.i_8
        )
        val imageText = arrayOf(
            "Image_1","Image_2","Image_3","Image_4",
            "Image_5","Image_6","Image_7","Image_8"
        )
        val heading = arrayOf(
            "Heading-1","Heading-2","Heading-3","Heading-4",
            "Heading-5","Heading-6","Heading-7","Heading-8"
        )
        val subPath = arrayOf(
            "1 Sub Path","2 Sub Paths","3 Sub Paths","4 Sub Paths",
            "5 Sub Paths","6 Sub Paths","7 Sub Paths","8 Sub Paths"
        )
        placesArrayList = ArrayList()
        for(i in imageText.indices){
            val places = Places(imageId[i],imageText[i],heading[i],subPath[i])
            placesArrayList.add(places)
        }

        binding.listView.adapter = MyAdapter(this,placesArrayList)
    }
}