package com.example.detailapplication.placeholder

import android.widget.Toast
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
    //creating list of strings
    val a = listOf("Nouman Khan", "Muad Siala", "Muhammad Khateeb", "Ahmed Mohammad")
    val text = "Loading : "
    val duration = Toast.LENGTH_SHORT
    //Log.i(text, "")
    private fun createPlaceholderItem(position: Int): PlaceholderItem {
        return PlaceholderItem(position.toString(), "Imam" , makeDetails(position))
    }

    private fun makeDetails(position: Int): String {

        var someList : Array<String> = arrayOf("Nouman Khan", "Muad Siala", "Muhammad Khateeb", "Ahmed Mohammad")
        someList.forEach { System.out.print(it) }

        val builder = StringBuilder()
        builder.append("Details about the Imam: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}