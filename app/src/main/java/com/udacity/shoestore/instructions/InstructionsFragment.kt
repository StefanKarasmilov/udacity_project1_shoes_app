package com.udacity.shoestore.instructions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.login.FIRST_LOGIN_KEY

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        binding.btnNextInstructions.setOnClickListener { navToShoesListScreen() }

        return binding.root
    }

    private fun navToShoesListScreen() {
        saveFirstTimeLogin()
        findNavController().navigate(InstructionsFragmentDirections.actionInstructionsToShoesList())
    }

    private fun saveFirstTimeLogin() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        sharedPref!!.edit {
            putBoolean(FIRST_LOGIN_KEY, false)
            commit()
        }
    }

}