package ruzanna.game.retrofitusers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("api/users?")
    fun getUsers(@Query("page") page: Int): Call<MainResponse>
}
