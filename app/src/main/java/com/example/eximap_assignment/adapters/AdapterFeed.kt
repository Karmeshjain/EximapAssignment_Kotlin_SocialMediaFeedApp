package com.example.eximap_assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.eximap_assignment.ModelFeed
import com.example.eximap_assignment.R


class AdapterFeed(var context: Context?, modelFeedArrayList: ArrayList<ModelFeed>) : RecyclerView.Adapter<AdapterFeed.MyViewHolder>() {
    var modelFeedArrayList = ArrayList<ModelFeed>()
    var glide: RequestManager

    init {
        this.modelFeedArrayList = modelFeedArrayList
        glide = context?.let { Glide.with(it) }!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_feed, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val modelFeed = modelFeedArrayList[position]
        holder.tv_name.text = modelFeed.name
        holder.tv_time.text = modelFeed.time
        holder.tv_likes.text = modelFeed.likes.toString()
        holder.tv_comments.text = modelFeed.comments.toString() + " comments"
        holder.tv_status.text = modelFeed.status
        glide.load(modelFeed.propic).into(holder.imgView_proPic)
        if (modelFeed.postpic == 0) {
            holder.imgView_postPic.visibility = View.GONE
        } else {
            holder.imgView_postPic.visibility = View.VISIBLE
            glide.load(modelFeed.postpic).into(holder.imgView_postPic)
        }
    }

    override fun getItemCount(): Int {
        return modelFeedArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name: TextView
        var tv_time: TextView
        var tv_likes: TextView
        var tv_comments: TextView
        var tv_status: TextView
        var imgView_proPic: ImageView
        var imgView_postPic: ImageView

        init {
            imgView_proPic = itemView.findViewById<View>(R.id.imgView_proPic) as ImageView
            imgView_postPic = itemView.findViewById<View>(R.id.imgView_postPic) as ImageView
            tv_name = itemView.findViewById<View>(R.id.tv_name) as TextView
            tv_time = itemView.findViewById<View>(R.id.tv_time) as TextView
            tv_likes = itemView.findViewById<View>(R.id.tv_like) as TextView
            tv_comments = itemView.findViewById<View>(R.id.tv_comment) as TextView
            tv_status = itemView.findViewById<View>(R.id.tv_status) as TextView
        }
    }
}