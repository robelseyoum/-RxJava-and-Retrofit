package com.robelseyoum3.startwarsretrofitobserver.views.fragmentviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.startwarsretrofitobserver.R
import com.robelseyoum3.startwarsretrofitobserver.common.heightTofeet
import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource
import kotlinx.android.synthetic.main.activity_news_row.view.*

class ActorAdaptor(private val movieSource: MovieSource): RecyclerView.Adapter<ActorAdaptor.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        //return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_news_row, parent, false))
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_news_row, parent, false))

    }

    override fun getItemCount(): Int {
       return movieSource.results.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {

        holder.tvActor.text = movieSource.results[position].name
        holder.tvHeight.text = heightTofeet(movieSource.results[position].height).toString()
        holder.tvWeight.text = movieSource.results[position].mass.toString()
    }


    class ActorViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val tvActor = view.tv_actor_name
        val tvHeight = view.tv_height
        val tvWeight = view.tv_weight
    }



}






