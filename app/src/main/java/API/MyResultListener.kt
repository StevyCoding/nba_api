package API

import Models.Player

interface MyResultListener {
    public fun onData(players : List<Player>)
    public fun onFailed();
}

interface MyResultListener2 {
    public fun onData(players : Player)
    public fun onFailed();
}