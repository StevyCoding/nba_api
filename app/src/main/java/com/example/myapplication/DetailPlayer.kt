package com.example.myapplication

import API.InstancePlayer
import API.MyResultListener
import API.MyResultListener2
import API.URL
import Adapter.AdapterPlayer
import Models.Player
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailPlayer : AppCompatActivity() {

    var playerList = Player()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)


        var instancePlayer : InstancePlayer = InstancePlayer()

            Log.d("actual id", URL.idPlayer.toString())
        var firstname = findViewById<TextView>(R.id.textViewDetail1).text
        firstname = "firstname changed"
        instancePlayer.getPlayer(object : MyResultListener2 {
            override fun onData(player : Player) {

                var firstname = findViewById<TextView>(R.id.textViewDetail1)
                var lastname = findViewById<TextView>(R.id.textViewDetail2)
                var team = findViewById<TextView>(R.id.textViewDetail3)

                var position = findViewById<TextView>(R.id.textViewDetail4)
                var height = findViewById<TextView>(R.id.textViewDetail5)
                var weight = findViewById<TextView>(R.id.textViewDetail11)

                var team2 = findViewById<TextView>(R.id.textViewDetail6)
                var abbreviation = findViewById<TextView>(R.id.textViewDetail7)
                var city = findViewById<TextView>(R.id.textViewDetail8)
                var conference = findViewById<TextView>(R.id.textViewDetail9)
                var division = findViewById<TextView>(R.id.textViewDetail10)

                firstname.setText( "firstname :"+player.first_name)
                lastname.setText("last name :"+player.last_name)
                team.setText("team : "+player.team?.name)
                position.setText("position :"+player.position)
                height.setText("height :"+player.height_feet.toString())
                weight.setText("weight :"+player.weight_pounds.toString())

                team2.setText("team : "+player.team?.name)
                abbreviation.setText("abbreviation : "+player.team?.abbreviation)
                city.setText("city: "+player.team?.city)
                conference.setText("conference : "+player.team?.conference)
                division.setText("division : "+player.team?.division)

            }

            override fun onFailed() {

            }

        })


    }

}