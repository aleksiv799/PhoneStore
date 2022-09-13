package com.my.udacity.phonestore.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.my.udacity.phonestore.R
import com.my.udacity.phonestore.databinding.FragmentIntroBinding

class IntroFragment : Fragment(R.layout.fragment_intro) {

    private lateinit var binding: FragmentIntroBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIntroBinding.bind(view)

        binding.btnIntro.setOnClickListener {
            actionOnNextScreen()
        }
    }

    fun actionOnNextScreen() {
        findNavController().navigate(R.id.action_introFragment_to_instructionFragment)
    }
}