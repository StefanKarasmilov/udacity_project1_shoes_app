package com.udacity.shoestore.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListFragmentViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    fun addShoes(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

}