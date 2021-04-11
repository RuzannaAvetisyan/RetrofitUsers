package ruzanna.game.retrofitusers

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val gson = GsonBuilder().setLenient().create()

    private val _retrofit = Retrofit.Builder()
        .baseUrl(
            "https://reqres.in"
        )
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retrofit: Retrofit
        get() {
            return _retrofit
        }
}