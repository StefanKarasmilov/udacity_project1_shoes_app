package com.udacity.shoestore.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoes.ShoesListFragmentViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: ShoesListFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSave.setOnClickListener {
            if (checkFields()) {
                saveShoes()
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    private fun checkFields(): Boolean {
        binding.apply {
            when {
                etNameShoes.text.isEmpty() -> etNameShoes.error = "Required field"
                etCompany.text.isEmpty() -> etCompany.error = "Required field"
                etShoesSize.text.isEmpty() -> etShoesSize.error = "Required field"
                etShoesDescription.text.isEmpty() -> etShoesDescription.error = "Required field"
                else -> return true
            }
        }
        return false
    }

    private fun saveShoes() {
        binding.apply {
            val shoes = Shoe(
                name = etNameShoes.text.toString(),
                size = etShoesSize.text.toString().toDouble(),
                company = etCompany.text.toString(),
                description = etShoesDescription.text.toString()
            )
            viewModel.addShoes(shoes)
        }
    }

}