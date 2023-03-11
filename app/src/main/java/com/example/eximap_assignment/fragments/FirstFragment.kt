package com.example.eximap_assignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eximap_assignment.ModelFeed
import com.example.eximap_assignment.R
import com.example.eximap_assignment.adapters.AdapterFeed



class FirstFragment : Fragment()
{

    var recyclerView: RecyclerView? = null
    var modelFeedArrayList = ArrayList<ModelFeed>()
    var adapterFeed: AdapterFeed? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun populateRecyclerView() {
        var modelFeed = ModelFeed(1, 9, 2, R.drawable.ic_propic1, R.drawable.img_post1,
            "Ayush Agarwal", "2 hrs", "What is Urvar?")
        modelFeedArrayList.add(modelFeed)
        modelFeed = ModelFeed(2, 26, 6, R.drawable.ic_propic2, 0,
            "Anjali Shrestha", "9 hrs", """
     Don't be afraid of your fears. They're not there to scare you. They're there to 
     let you know that something is worth it.
     """.trimIndent())
        modelFeedArrayList.add(modelFeed)
        modelFeed = ModelFeed(3, 17, 5, R.drawable.ic_propic3, R.drawable.img_post1,
            "Lakshya Ram", "13 hrs", "That reflection!!!")
        modelFeedArrayList.add(modelFeed)
        adapterFeed!!.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        recyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        adapterFeed= AdapterFeed(context,modelFeedArrayList)
        recyclerView?.adapter =adapterFeed
        populateRecyclerView()
        return view
    }

}