package com.my.udacity.phonestore.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.my.udacity.phonestore.R
import com.my.udacity.phonestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment(R.layout.fragment_instruction) {

    private lateinit var binding: FragmentInstructionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInstructionBinding.bind(view)

        binding.btnInstruction.setOnClickListener {
            onNextScreen()
        }
    }

    private fun onNextScreen() {
        findNavController().navigate(R.id.action_instructionFragment_to_listOfPhonesFragment)
    }


}