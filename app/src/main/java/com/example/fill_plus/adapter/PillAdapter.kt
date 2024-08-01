package com.example.fill_plus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fill_plus.Pills
import com.example.fill_plus.R
import java.util.Locale

class PillAdapter(
    private var originalList: ArrayList<Pills>,
    private val listener: PillAdapterListener
) : RecyclerView.Adapter<PillAdapter.CustomViewHolder>() {
    private var pillList: ArrayList<Pills> = ArrayList(originalList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val pill = originalList[position]
        holder.image.setImageResource(pill.image)
        holder.category.text = pill.category
        holder.name.text = pill.name
        holder.button.text = if (pill.isButtonClicked) "V" else ""

        holder.button.setOnClickListener {
            pill.isButtonClicked = !pill.isButtonClicked
            holder.button.text = if (pill.isButtonClicked) "V" else ""
            listener.onItemSelected(getSelectedItemCount())
        }
    }

    override fun getItemCount(): Int {
        return originalList.size
    }

    fun filterList(query: String) {
        if (query.isNotEmpty()) {
            val lowerCaseQuery = query.toLowerCase(Locale.getDefault())
            val filteredList = arrayListOf<Pills>()

            for (pill in originalList) {
                if (pill.name.toLowerCase(Locale.getDefault()).contains(lowerCaseQuery)) {
                    filteredList.add(pill)
                }
            }

            // Update the original list with the filtered list
            originalList = filteredList
        } else {
            // If the query is empty, show the original list
            originalList = ArrayList(pillList)
        }

        notifyDataSetChanged()
        listener.onItemSelected(getSelectedItemCount())
    }

    private fun getSelectedItemCount(): Int {
        var count = 0
        for (pill in originalList) {
            if (pill.isButtonClicked) {
                count++
            }
        }
        return count
    }

    interface PillAdapterListener {
        fun onItemSelected(count: Int)
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.id_pill)
        val category = itemView.findViewById<TextView>(R.id.tv_catrgori)
        val name = itemView.findViewById<TextView>(R.id.tv_name2)
        val button = itemView.findViewById<Button>(R.id.button53)
    }
}












