package com.example.recylerviewexample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recylerviewexample.Models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<BlogPost> = ArrayList()
    //    it will be an array list of blog post objects

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(blogList: List<BlogPost>) {
        items = blogList
    }
    //     Need to create a custom viewholder to say what a viewholder should be like
    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val blogImage = itemView.blog_image
        val blogTitle = itemView.blog_title
        val blogAuthor = itemView.blog_author
        //    these are referring to the ids of the views we've created in our layouts
        fun bind(blogPost: BlogPost){
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)
        }
//    This sets some defualt properties for glide to say what to display if there's an error or if an image can't be dislpayed

    }

}

// Keeps only the view holders visible kept in memory (and a couple above and a couple below)
// So those that are not in view will not be stored in memory
// This is the most efficient way of storing infinite scrolls

