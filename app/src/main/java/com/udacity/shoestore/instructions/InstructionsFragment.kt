package com.udacity.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        activity?.title = "Instructions"

        binding.btnNextInstructions.setOnClickListener { navToShoesListScreen() }

        return binding.root
    }

    private fun navToShoesListScreen() {
        findNavController().navigate(InstructionsFragmentDirections.actionInstructionsToShoesList())
    }

}