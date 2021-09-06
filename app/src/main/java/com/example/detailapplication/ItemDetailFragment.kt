package com.example.detailapplication

import android.app.Activity
import android.content.ClipData
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.detailapplication.activity.MainActivity
import com.example.detailapplication.databinding.FragmentItemDetailBinding
import com.example.detailapplication.placeholder.PlaceholderContent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.play.core.appupdate.i
import com.google.android.play.core.assetpacks.v
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */

class ItemDetailFragment : Fragment() {

    /**
     * The placeholder content this fragment is presenting.
     */
    private var item: PlaceholderContent.PlaceholderItem? = null

    private lateinit var itemDetailTextView: TextView

    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the placeholder content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                //item = PlaceholderContent.ITEM_MAP[it.getString("Test")]
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var activity = (this).apply {
            //ToBeCalled.callMe()
        }

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.toolbarLayout?.title = item?.content
        val itemDetailViewText = "\n\nNouman Khalid\nQuran Teacher\nPhone number +971 55 789 2356\n"
        itemDetailTextView = binding.itemDetail
        // Show the placeholder content as text in a TextView.
        item?.let {
            itemDetailTextView.text = itemDetailViewText //+ it.details
        }
        val storage = Firebase.storage("gs://imamfinder-ac929.appspot.com")
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        //var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        return rootView
    }
    /*
private void googleBtnUi() {
// TODO Auto-generated method stub


SignInButton googleButton = (SignInButton) findViewById(R.id.google_button);
googleButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

for (int i = 0; i < googleButton.getChildCount(); i++) {
    View v = googleButton.getChildAt(i);

    if (v instanceof TextView)
    {
        TextView tv = (TextView) v;
        tv.setTextSize(14);
        tv.setTypeface(null, Typeface.NORMAL);
        tv.setText("My Text");
        tv.setTextColor(Color.parseColor("#FFFFFF"));
        tv.setBackgroundDrawable(getResources().getDrawable(
            R.drawable.ic_launcher));
        tv.setSingleLine(true);
        tv.setPadding(15, 15, 15, 15);

        return;
    }
}

    }
    */

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}