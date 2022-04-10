package com.example.kotlinarchitecttraining.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.kotlinarchitecttraining.R

class SecondFragment : Fragment() {

    private lateinit var backBtn: Button
    private lateinit var nextBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        backBtn = view.findViewById(R.id.back_btn)
        nextBtn = view.findViewById(R.id.next_btn)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextBtn.setOnClickListener {
            findNavController().navigate(R.id.second_to_third)
        }
    }
}