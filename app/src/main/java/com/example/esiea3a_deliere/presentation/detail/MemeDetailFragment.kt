package com.example.esiea3a_deliere.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.esiea3a_deliere.R
import com.squareup.picasso.Picasso


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MemeDetailFragment : Fragment() {

    private lateinit var textViewName : TextView
    private lateinit var imageView : ImageView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meme_detail, container, false)
    }

    //val args: MemeDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.textview_second)
        imageView = view.findViewById(R.id.imageView)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.navToMemeDetailFragment)
        }
        val memeName: String? = arguments?.getString("memeName");
        val memeImg: String? = arguments?.getString("memeImg");

        textViewName.text = memeName
        Picasso.get().load(memeImg).into(imageView)
    }

}