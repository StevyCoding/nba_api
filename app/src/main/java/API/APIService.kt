package API


import API.URL.Companion.idPlayer
import Models.Data
import Models.Player
import retrofit2.http.GET
import retrofit2.*
import retrofit2.http.Url


interface APIService {
    @GET("/api/v1/players")
    fun getPlayers() : Call<Data>

    @GET
    fun getPlayer(@Url url : String) : Call<Player>
}