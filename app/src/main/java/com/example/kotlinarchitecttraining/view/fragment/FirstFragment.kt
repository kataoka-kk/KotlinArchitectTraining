package com.example.kotlinarchitecttraining.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.kotlinarchitecttraining.R

class FirstFragment : Fragment() {

    private lateinit var nextBtn: Button
    private lateinit var shareBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        nextBtn = view.findViewById(R.id.next_btn)
        shareBtn = view.findViewById(R.id.image_share_btn)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextBtn.setOnClickListener {
            findNavController().navigate(R.id.first_to_second)
        }

        shareBtn.setOnClickListener {
            // textの他アプリ共有の仕方
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}