package ruzanna.game.retrofitusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var usersList:List<User> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(usersList[position])
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun init(user: User){
            itemView.apply {
                user_id.text = "ID: ${user.id}"
                email.text = user.email
                name.text = "${user.firstName} ${user.lastName}"

                Glide.with(context)
                    .load(user.avatar)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .centerCrop()
                    .into(avatar)
            }
        }

    }
}