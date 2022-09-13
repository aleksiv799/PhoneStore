package com.my.udacity.phonestore.presentation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.my.udacity.phonestore.R
import com.my.udacity.phonestore.databinding.FragmentListOfPhonesBinding
import com.my.udacity.phonestore.databinding.ItemDetailsBinding
import com.my.udacity.phonestore.model.ActivityViewModel


class ListOfPhonesFragment : Fragment() {

    private lateinit var binding: FragmentListOfPhonesBinding
    private lateinit var activityViewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_of_phones,
            container,
            false
        )
        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ListOfPhonesFragmentDirections.actionListOfPhonesFragmentToAddPhoneFragment()
            )
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityViewModel = activityViewModels<ActivityViewModel>().value
        activityViewModel.phoneList.observe(viewLifecycleOwner) {
            with(binding) {
                linearLayout.removeAllViews()
                for (phone in it) {
                    val phoneItemBinding = DataBindingUtil.inflate<ItemDetailsBinding>(
                        layoutInflater,
                        R.layout.item_details,
                        linearLayout,
                        true
                    )
                    phoneItemBinding.phone = phone
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_logout -> {
                findNavController().navigate(ListOfPhonesFragmentDirections.actionGlobalToLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

}