package Models

data class Player(
    var id: Int? = null,
    var first_name: String? = null,
    var last_name: String? = null,
    var position: String? = null,
    var height_feet: Int? = null,
    var height_inches: Int? = null,
    var team: Team? = null,
    var weight_pounds : Int? = null
) {

}