package com.example.esiea3a_deliere.presentation.list

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a_deliere.R
import com.example.esiea3a_deliere.presentation.Singletons.Companion.memesApi
import com.example.esiea3a_deliere.presentation.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MemeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MemesAdapter(listOf(), ::onClickMeme)

    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.meme_recyclerview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        callApi()
    }

    private fun callApi() {

        memesApi.getMemesList().enqueue(object : Callback<DataResponse> {
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val memeResponse = response.body()!!
                    adapter.updateList(memeResponse.data.memes)
                }
            }
        })
    }

    private fun onClickMeme(meme: Meme) {
        findNavController().navigate(R.id.navToMemeDetailFragment, bundleOf(
                "memeName" to meme.name,
                "memeImg" to meme.url
        ))
    }
}