package com.example.preyanshjain

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context:Activity, private val arrayList : ArrayList<Places>):
    ArrayAdapter<Places>(context,R.layout.list_item,arrayList){
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item,null)

        val imageView: ImageView = view.findViewById(R.id.image_view)
        val imageText: TextView = view.findViewById(R.id.image_text)
        val heading : TextView = view.findViewById(R.id.heading)
        val subPath : TextView = view.findViewById(R.id.sub_paths)

        imageView.setImageResource(arrayList[position].imageId)
        imageText.text = arrayList[position].imageText
        heading.text = arrayList[position].heading
        subPath.text = arrayList[position].subPath

        return view
    }
}