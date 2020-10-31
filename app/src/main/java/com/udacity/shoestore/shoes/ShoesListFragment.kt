package com.udacity.shoestore.shoes

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoes_list.*


class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private val viewModel: ShoesListFragmentViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_shoes_list,
            container,
            false
        )

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionListToDetail())
        }

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            for ((index, shoe) in shoes.withIndex()) {
                val card = showCard(shoe)
                linearLayout.addView(card, index)
            }
        })

        return binding.root
    }

    private fun showCard(shoe: Shoe): CardView {
        val cardview = CardView(requireContext())
        val linearLayout = LinearLayout(requireContext())
        val textName = TextView(requireContext())
        val textSize = TextView(requireContext())
        val textCompany = TextView(requireContext())
        val textDescription = TextView(requireContext())

        textName.text = "Name: ${shoe.name}"
        textSize.text = "Size: ${shoe.size}"
        textCompany.text = "Company: ${shoe.company}"
        textDescription.text = "Description: ${shoe.description}"

        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setPadding(16)
        linearLayout.addView(textName)
        linearLayout.addView(textSize)
        linearLayout.addView(textCompany)
        linearLayout.addView(textDescription)

        val layoutparams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        cardview.layoutParams = layoutparams
        cardview.radius = 15f
        cardview.setPadding(25, 25, 25, 25)
        cardview.setCardBackgroundColor(Color.WHITE)
        cardview.maxCardElevation = 30f
        cardview.maxCardElevation = 6f

        cardview.addView(linearLayout)

        return cardview
    }

}