package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.uielementspart2.models.Song

class DisplayNewSongActivity : AppCompatActivity() {
    lateinit var songsListView: ListView
    lateinit var songsTableHandler: SongsTableHandler
    lateinit var songs: MutableList<Song>
    lateinit var adapter: ArrayAdapter<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_new_song)

        songsListView = findViewById(R.id.songsListView)
        songsTableHandler = SongsTableHandler(this)
        songs = songsTableHandler.read()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, songs)
        songsListView.adapter = adapter
    }
}