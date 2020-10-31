package com.udacity.shoestore.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoes.ShoesListFragmentViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: ShoesListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        viewModel = ViewModelProvider(this).get(ShoesListFragmentViewModel::class.java)

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSave.setOnClickListener {
            saveShoes()
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun saveShoes() {
        val shoes = Shoe(
            name = binding.etNameShoes.text.toString(),
            size = binding.etShoesSize.text.toString().toDouble(),
            company = binding.etCompany.text.toString(),
            description = ""
        )

        viewModel.addShoes(shoes)
    }

}