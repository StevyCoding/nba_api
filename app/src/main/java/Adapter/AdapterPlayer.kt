package Adapter

import API.URL
import Models.Player
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailPlayer
import com.example.myapplication.R


class AdapterPlayer :

    RecyclerView.Adapter<AdapterPlayer.PlayerViewHolder>() {
    private var playerList: List<Player> = ArrayList<Player>()
    public fun setData(listplayer: List<Player>) {
        playerList = listplayer
    }

    @NonNull
    @Override
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return PlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val currentItem = playerList[position]

        holder.textViewNamePlayer.text = currentItem.first_name;
        holder.textViewTeamPlayer.text = currentItem.last_name;
        holder.id = currentItem.id!!

    }

    override fun getItemCount() = playerList.size

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView2 = itemView.findViewById(R.id.textViewNamePlayer) as TextView;
        val textView3 = itemView.findViewById(R.id.textViewTeamPlayer) as TextView;
        var id : Int = 0
        val textViewNamePlayer: TextView = textView2
        val textViewTeamPlayer: TextView = textView3


        init {
            var button : Button = itemView.findViewById(R.id.buttonPlayer) as Button
            button.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {

                    URL.idPlayer = id
                    v!!.context.startActivity(Intent(v!!.context, DetailPlayer::class.java))

                }

            })




    }



}



}