package API

import API.URL.Companion.idPlayer
import Models.Data
import Models.Player
import android.util.Log
import androidx.annotation.Nullable

import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class InstancePlayer {
    private var url = "https://balldontlie.io"

    // players
    private var retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getPlayerAPI(): APIService? {
        var playerApi = retrofit.create(APIService::class.java)
        return playerApi
    }

    //player
    private var retrofit2 = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getPlayerAPI2(): APIService? {
        var playerApi2 = retrofit2.create(APIService::class.java)
        return playerApi2
    }

    fun getPlayers(@Nullable myResultListener: MyResultListener) {


        var playerApi = this.getPlayerAPI()

        var call = playerApi?.getPlayers()

        if (call != null) {
            call.enqueue(object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    val players: List<Player>? = response.body()?.data
                    if (players != null) {
                        myResultListener.onData(players)
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }


    }

    fun getPlayer(@Nullable myResultListener: MyResultListener2) {


        var playerApi = this.getPlayerAPI2()

        var call = playerApi?.getPlayer("/api/v1/players/" + idPlayer)

        if (call != null) {
            call.enqueue(object : Callback<Player> {
                override fun onResponse(call: Call<Player>, response: Response<Player>) {
                    var p: Player? = response.body()
                    if (p != null) {
                        myResultListener.onData(p)
                    }
                }

                override fun onFailure(call: Call<Player>, t: Throwable) {
                    myResultListener.onFailed()
                }
            })

        }


    }

}