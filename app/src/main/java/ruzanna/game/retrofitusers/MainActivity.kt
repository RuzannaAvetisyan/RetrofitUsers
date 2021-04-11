package ruzanna.game.retrofitusers

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Waiting for data loading.")
        progressDialog.setMessage("Loading...")


        val adapter = UsersAdapter()
        user_list.adapter = adapter
        user_list.layoutManager = LinearLayoutManager(this)


        val productAPI = ApiService.retrofit.create(UserApi::class.java)


        val call: Call<MainResponse> = productAPI.getUsers(2)

        progressDialog.show()
        call.enqueue(object : Callback<MainResponse> {
            override fun onResponse(
                call: Call<MainResponse>,
                response: Response<MainResponse>
            ) {
                user_list.post {
                    adapter.usersList = response.body()!!.users
                }
                adapter.notifyDataSetChanged()
                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
            }

        })

    }
}
