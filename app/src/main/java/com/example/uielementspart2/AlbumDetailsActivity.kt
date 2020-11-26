package com.example.uielementspart2


import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_album_details.*


class AlbumDetailsActivity : AppCompatActivity() {

    private var adapter: ArrayAdapter<String>? = null
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
        registerForContextMenu(albumDetailListView)
}

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(menu,v,menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.album_list_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_item -> {
                val intent = intent
                val position = intent.extras!!.getInt("position")
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Remove song from album?")
                    .setCancelable(false)
                    .setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, which ->
                        if(position == 0){
                            selectedSong.removeAt(info.position)
                        }
                        else if(position == 1){
                            selectedSong.removeAt(info.position)
                        }
                        else {
                           selectedSong.removeAt(info.position)
                        }
                        adapter?.notifyDataSetChanged()
                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener{
                            dialog, which ->
                    })
                val alert = dialogBuilder.create()
                alert.setTitle("Album Dialog")
                alert.show()
            }
        }
        return super.onContextItemSelected(item)
    }


}
