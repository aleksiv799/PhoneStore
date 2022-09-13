package com.my.udacity.phonestore.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.my.udacity.phonestore.R
import com.my.udacity.phonestore.databinding.FragmentAddItemBinding
import com.my.udacity.phonestore.model.ActivityViewModel
import com.my.udacity.phonestore.model.Phone
import com.my.udacity.phonestore.model.PhoneViewModel


class AddPhoneFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding
    private lateinit var addPhoneViewModel: PhoneViewModel
    private lateinit var activityViewModel: ActivityViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_add_item,
            container,
            false
        )
        navController = findNavController()
        addPhoneViewModel = ViewModelProvider(this)[PhoneViewModel::class.java]
        addPhoneViewModel.data.observe(viewLifecycleOwner) { phone ->
            activityViewModel.addPhone(phone)
            navController.navigateUp()
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityViewModel = activityViewModels<ActivityViewModel>().value
        binding.viewModel = addPhoneViewModel
        binding.phone = Phone(name = "", systemOS = "", company = "", description = "")
        binding.btnCancel.setOnClickListener {
            navController.navigateUp()
        }
    }
}