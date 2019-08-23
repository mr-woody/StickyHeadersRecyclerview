package com.okay.sampletamplate.sample.adapter

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import ccom.okay.sticky.strategy.GroupingStrategy
import com.okay.sampletamplate.sample.R
import com.okay.sampletamplate.sample.modle.Item
import com.okay.sticky.callback.StickyCallback

import java.util.ArrayList

import android.support.v7.widget.RecyclerView.NO_POSITION
import android.view.LayoutInflater.from

class RecyclerAdapter(items: List<Item>) : RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder>(), StickyCallback<Item> {

    private val groupingStrategy:GroupingStrategy<Item>

    private val data = ArrayList<Item>()

    init {
        items?.let { this.data.addAll(it) }
        groupingStrategy = GroupingStrategy.of(this).reduce { it->it.title.contains("Header")}
        //strategy = GroupingStrategy.of(this).reduce(BinaryCondition<String> { t1, t2 -> t1[0] != t2[0] })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = from(parent.context).inflate(R.layout.item_view, parent, false)
        val viewHolder: BaseViewHolder
        if (viewType == 0) {
            viewHolder = MyViewHolder(view)
        } else {
            viewHolder = MyOtherViewHolder(view)
        }
        view.findViewById<View>(R.id.button2)
            .setOnClickListener { v -> Toast.makeText(v.context, "点击了button2", Toast.LENGTH_SHORT).show() }

        view.setOnClickListener {
            // This is unsafe to do in OnClickListeners attached to sticky headers. The adapter
            // position of the holder will be out of sync if any items have been added/removed.
            // If a click listener needs to be set on a sticky header, it is recommended to identify the header
            // based on its backing model, rather than position in the data set.
            val position = viewHolder.adapterPosition
            if (position != NO_POSITION) {
                val newData = ArrayList(data)
                newData.removeAt(position)
                setData(newData)
                notifyDataSetChanged()
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = data[position]
        holder.titleTextView.text = item.title
        holder.messageTextView.text = item.message
        if (position != 0 && position % 12 == 0) {
            holder.itemView.setPadding(0, 100, 0, 100)
        } else {
            holder.itemView.setPadding(0, 0, 0, 0)
        }
        if (groupingStrategy.isGroupIndex(position)) {
            holder.itemView.setBackgroundColor(Color.CYAN)
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != 0 && position % 16 == 0) {
            1
        } else 0
    }

    override fun getGroupingStrategy(): GroupingStrategy<Item> {
        return groupingStrategy
    }

    override fun getItems(): List<Item> {
        return data
    }


    fun setData(items: List<Item>) {
        data.clear()
        data.addAll(items)
    }

    private class MyViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView)

    private class MyOtherViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView)

    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView: TextView
        var messageTextView: TextView

        init {
            titleTextView = itemView.findViewById<View>(R.id.tv_title) as TextView
            messageTextView = itemView.findViewById<View>(R.id.tv_message) as TextView
        }
    }

}
