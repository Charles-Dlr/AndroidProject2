package com.example.esiea3a_deliere.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a_deliere.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ImocaListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = ImocaAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imoca_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.imoca_recyclerview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        val ImocaList:ArrayList<String> = arrayListOf<String>().apply{
            add("L'Occitane en Provence")
            add("Hugo Boss")
            add("V and B Mayenne")
            add("Yes We Cam!")
        }

        adapter.updateList(ImocaList)
    }
}