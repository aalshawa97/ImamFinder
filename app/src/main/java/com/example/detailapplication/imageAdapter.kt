package com.example.detailapplication
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

private val counter = 0
private val item = 0
private val itemId = 0L

public class imageAdapter : BaseAdapter()
{
    override fun getCount(): Int {
        //TODO("Getting the number of images!")
        return counter
    }

    override fun getItem(position: Int): Any {
        return item
    }

    override fun getItemId(position: Int): Long {
        return itemId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = this.getView(R.layout.recycler_view,convertView, parent)

        return rowView
    }
}
