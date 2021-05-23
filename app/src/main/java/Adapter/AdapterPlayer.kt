package Adapter

import Models.Player
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R



class AdapterPlayer :

    RecyclerView.Adapter<AdapterPlayer.PlayerViewHolder>() {
    private var playerList: List<Player> = ArrayList<Player>()
    public fun setData(listplayer : List<Player>){
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


    }

    override fun getItemCount() = playerList.size

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener  {

        val textView2 = itemView.findViewById(R.id.textViewNamePlayer) as TextView;
        val textView3 = itemView.findViewById(R.id.textViewTeamPlayer) as TextView;

        val  button = itemView.findViewById(R.id.buttonPlayer) as Button

        lateinit var mOnBtnListener : OnBtnListener

        val textViewNamePlayer: TextView = textView2
        val textViewTeamPlayer: TextView = textView3

        public fun ViewHolder(itemView: View, onBtnListener: OnBtnListener) {

            mOnBtnListener = onBtnListener
            itemView.findViewById<Button>(R.id.buttonPlayer).setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            Log.d(TAG, "onClick: $adapterPosition")

        }

    }
    interface OnBtnListener {
        fun onBtnClick(position: Int)
    }


}