package com.example.devrevtest.presentaion

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.devrevtest.R
import com.example.devrevtest.databinding.ItemLayoutBinding
import com.example.mylibrary.Movie
import com.example.mylibrary.MovieResponse


class MovieAdapter(private val context: Context,
                   private var userList: List<Movie>,
                   private val onItemClick: (Movie) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
        // Set click listener
        holder.itemView.setOnClickListener {
            onItemClick.invoke(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUsers(users: List<Movie>) {
        userList = users
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: Movie) {
            binding.user = user
            binding.context = context
            binding.executePendingBindings()

            val imageUrl = "https://image.tmdb.org/t/p/original${user.poster_path}"

            Glide.with(context)
                .load(imageUrl)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.avatarImageView)

        }
    }
}
