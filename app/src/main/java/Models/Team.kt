package Models

data class Team(
    var id: Int? = null,
    var abbreviation: String? = null,
    var conference:String?,
    var division:String?,
    var full_name: String?,
    var name:String?
) {

}