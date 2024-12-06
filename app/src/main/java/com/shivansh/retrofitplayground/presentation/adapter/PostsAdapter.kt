package com.shivansh.retrofitplayground.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.shivansh.retrofitplayground.data.entity.PostEntity
import com.shivansh.retrofitplayground.databinding.PostItemBinding
import com.shivansh.retrofitplayground.databinding.PostItemHorizontalBinding

class PostsAdapter: RecyclerView.Adapter<ViewHolder>() {

    private var posts = listOf<PostEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val type = Type.entries[viewType]
        val inflater = LayoutInflater.from(parent.context)
        return when (type) {
            Type.EVEN -> PostViewHolder(PostItemBinding.inflate(inflater, parent, false))
            Type.ODD -> HorizontalPostsViewHolder(PostItemHorizontalBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        if (holder is PostViewHolder) {
            holder.bind(post)
        } else if (holder is HorizontalPostsViewHolder) {
            holder.bind(post)
        }
    }

    override fun getItemCount() = posts.size

    override fun getItemViewType(position: Int): Int {
        val post = posts[position]
        if (post.id %2 == 0)
            return Type.EVEN.ordinal
        return Type.ODD.ordinal
    }

    enum class Type {
        EVEN, ODD
    }

    fun updateData(data: List<PostEntity>) {
        posts = data
        notifyDataSetChanged()
    }


    inner class PostViewHolder(private val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity) {
            binding.apply {
                tvTitle.text = post.title
                tvBody.text = post.body
            }
        }
    }

    inner class HorizontalPostsViewHolder(private val binding: PostItemHorizontalBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity) {
            binding.apply {
                tvTitle.text = post.title
                tvBody.text = post.body
            }
        }
    }

    companion object {
//        var con: Context? = null
    }
}