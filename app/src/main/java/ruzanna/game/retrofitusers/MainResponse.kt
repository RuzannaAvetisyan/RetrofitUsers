package ruzanna.game.retrofitusers

import com.google.gson.annotations.SerializedName

class MainResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("per_page") var per_page: Int,
    @SerializedName("total") var total: Int,
    @SerializedName("total_pages") var total_pages: Int,
    @SerializedName("data") var users: List<User>)

