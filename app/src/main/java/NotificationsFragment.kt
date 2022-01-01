package com.example.detailapplication

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.detailapplication.activity.NotificationsViewModel
//import com.example.detailapplication.databinding.FragmentNotificationsBinding
import com.example.detailapplication.R
import com.example.detailapplication.activity.*
import com.example.detailapplication.databinding.FragmentNotificationsBinding
import com.firebase.ui.firestore.FirestoreRecyclerOptions
//import com.firebase.ui.firestore.FirestoreRecyclerAdapter
//import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import firestorerecycleradaptersample.FirestoreRecyclerAdapter
//import firestorerecycleradaptersample.FirestoreRecyclerAdapter
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import kotlin.concurrent.schedule

class NotificationsFragment : Fragment(){
    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null
    lateinit var editText: EditText
    lateinit var listView: ListView
    private var rootRef: FirebaseFirestore? = null
    private var fromUid: String? = ""
    //private var adapter: MessageAdapter? = null
    private lateinit var recycler_view  : RecyclerView
    private lateinit var recycler_viewFirestore  : FirestoreRecyclerAdapter
    private val binding get() = _binding!!

    /*
    inner class MessageAdapter internal constructor(options: FirestoreRecyclerOptions<Message>) : FirestoreRecyclerAdapter<Message, ChatActivity.MessageViewHolder>(options) {
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatActivity.MessageViewHolder {

       return if (viewType == R.layout.item_message_to) {
           //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_to, parent, false)

           ChatActivity.MessageViewHolder(
               view?.findViewById<View>(R.id.text_view) as View
           )
       } else {
           //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_from, parent, false)
           MessageViewHolder(view?.findViewById<View>(R.id.text_view) as View)
       }
   }

   override fun onBindViewHolder(holder: MessageViewHolder, position: Int, model: Message) {
       holder.setMessage(model)
   }

   override fun getItemViewType(position: Int): Int {
       return if (fromUid != getItem(position).fromUid) {
           R.layout.item_message_to
       } else {
           R.layout.item_message_from
       }
   }

   override fun onDataChanged() {
       recycler_view.layoutManager?.scrollToPosition(itemCount - 1)
   }


    }
*/
}