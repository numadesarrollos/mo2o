package com.example.mo2o.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mo2o.R
import com.example.mo2o.data.Recepy
import com.example.mo2o.extensions.onClick
import com.squareup.picasso.Picasso

class RecepiesAdapter(private val recepies: List<Recepy>, private val click: RecepiesViewHolder.OnItemClick) :
    RecyclerView.Adapter<RecepiesAdapter.RecepiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecepiesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = RecepiesViewHolder(inflater, parent)
        return holder
    }

    override fun getItemCount(): Int = recepies.size

    override fun onBindViewHolder(holder: RecepiesViewHolder, position: Int) {
        val recepy = recepies.get(position)
        holder.bind(recepy)
        holder.onClick { position, _ -> click.onItemClick(recepies.get(position),holder.ivRecepy) }
    }

    class RecepiesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.recepy_list_item, parent, false)) {

        val rvItem: LinearLayout by lazy { itemView.findViewById(R.id.rv_item) as LinearLayout }
        val ivRecepy: ImageView by lazy { itemView.findViewById(R.id.iv_item_recepy) as ImageView }
        val tvTitle: TextView by lazy { itemView.findViewById(R.id.tv_item_title) as TextView }
        val tvIngredients: TextView by lazy { itemView.findViewById(R.id.tv_item_ingredients) as TextView }
        val tvLink: TextView by lazy { itemView.findViewById(R.id.tv_item_link) as TextView }

        init {
            ViewCompat.setTransitionName(ivRecepy, "imageTransition$adapterPosition")
        }


        fun bind(recepy: Recepy) {
            tvTitle.text = recepy.title
            tvIngredients.text = recepy.ingredients
            tvLink.text = recepy.href
            if (!recepy.thumbnail.isEmpty())
                Picasso.get().load(recepy.thumbnail).into(ivRecepy)
        }

        interface OnItemClick {
            fun onItemClick(recepy: Recepy,image: ImageView)
        }
    }
}