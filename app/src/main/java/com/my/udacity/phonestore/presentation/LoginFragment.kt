package com.my.udacity.phonestore.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.my.udacity.phonestore.R
import com.my.udacity.phonestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnSignIn.setOnClickListener { actionOnNextScreen() }

        binding.btnSignUp.setOnClickListener { actionOnNextScreen() }
    }

    fun actionOnNextScreen() {
        findNavController().navigate(R.id.action_loginFragment_to_introFragment)
    }
}