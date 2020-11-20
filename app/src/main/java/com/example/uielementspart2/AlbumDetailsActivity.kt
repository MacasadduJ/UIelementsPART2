package com.example.uielementspart2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class AlbumDetailsActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val viewName = findViewById<TextView>(R.id.albumTitleTextView)
        val viewImage = findViewById<ImageView>(R.id.albumImageView)

        var albumSongs :Array<String> =arrayOf()
        val position = intent.extras!!.getString("position")

        if (position.equals("Shrek 1")){
            viewName.text = position
            viewImage.setImageResource(R.drawable.shrek1)
            albumSongs = arrayOf("I'm a believer", "All Star", "I'm on my way", "My beloved monster", "Hallelujah")
        }
        else if (position.equals("Shrek 2")){
            viewName.text = position
            viewImage.setImageResource(R.drawable.shrek2)
            albumSongs = arrayOf("Accidentally in Love", "Holding Out for a Hero", "Hello World", "Livin' la Vida Loca", "Funkytown", "Changes")
        }
        else if (position.equals("Shrek 3")){
            viewName.text = position
            viewImage.setImageResource(R.drawable.shrek3)
            albumSongs = arrayOf("What I've Done", "Final Showdown", "This Moment", "Do You Remember Rock 'n' Roll Radio?",
                "Live and Let Die")
        }
        var adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 , albumSongs)
        var albumDetailListView = findViewById<ListView>(R.id.albumDetailListView)
        albumDetailListView.adapter = adapter
    }
}
