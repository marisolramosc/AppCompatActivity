package com.example.appcompatactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApplicationsAdapter(context: Context, feedEntries: ArrayList<FeedEntry>): RecyclerView.Adapter<ApplicationsAdapter.ViewHolder>() {

    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<FeedEntry>? = null

    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationsAdapter.ViewHolder{
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.views, parent, false)
        return ViewHolder(view)
    }


    //Asignar valores a las filas cuando son reintroducidasa a la pantalla basadas en la posición que tienen en la vista
    override fun onBindViewHolder(holder: ApplicationsAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: FeedEntry = localFeedEntries!![position]
        holder.textArtist.text = currentFeedEntry.artist
        holder.textDescription.text = currentFeedEntry.summary.take(250).plus("...")
        holder.textName.text = currentFeedEntry.name
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        val textName: TextView = v.findViewById(R.id.textViewSong)
        val textArtist: TextView = v.findViewById(R.id.textViewArtist)
        val textDescription: TextView = v.findViewById(R.id.textViewSumary)

//        var textName: TextView? = null
//        init {
//            textName = v.findViewById(R.id.textViewName)
//        }
    }

}