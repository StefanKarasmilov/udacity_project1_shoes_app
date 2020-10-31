package com.udacity.shoestore.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import kotlinx.android.synthetic.main.fragment_shoes_list.*

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private lateinit var viewModel: ShoesListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoes_list, container, false)
        viewModel = ViewModelProvider(this).get(ShoesListFragmentViewModel::class.java)

        val textView = TextView(context)

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionListToDetail())
        }

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            var index = 0
            for (shoe in shoes) {
                textView.text = shoe.name
                linearLayout.addView(textView, index++)
            }
        })

        return binding.root
    }

}