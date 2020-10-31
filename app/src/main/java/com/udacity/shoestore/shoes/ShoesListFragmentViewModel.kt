package com.udacity.shoestore.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListFragmentViewModel : ViewModel() {

    private var list: ArrayList<Shoe> = arrayListOf()

    private var _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    init {
        list = arrayListOf<Shoe>(
            Shoe("this", 2.23, "", ""),
            Shoe("this12", 2.23, "", ""),
            Shoe("this12", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this12", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
            Shoe("this", 2.23, "", ""),
        )
        _shoes.value = list
    }

    fun addShoes(shoe: Shoe) {
        list.add(shoe)
    }

}