package com.example.myapplication

import API.InstancePlayer
import API.MyResultListener
import API.URL.Companion.idPlayer
import Adapter.AdapterPlayer
import Models.Player
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlayerListActivity : AppCompatActivity() {

    var playerList = ArrayList<Player>()
    var recyclerView: RecyclerView? = null
    var playerAdapter: AdapterPlayer = AdapterPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.adapter = playerAdapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
        var instancePlayer : InstancePlayer = InstancePlayer()
        var player: Player = Player()


        instancePlayer.getPlayers(object : MyResultListener {
            override fun onData(players: List<Player>) {

            Log.d(" name ",players.get(1).first_name.toString())
            playerAdapter.setData(players)
                recyclerView?.adapter = playerAdapter
            }

            override fun onFailed() {

            }

        })


    }




}