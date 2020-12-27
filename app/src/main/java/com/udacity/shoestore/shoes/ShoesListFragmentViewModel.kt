package com.udacity.shoestore.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListFragmentViewModel : ViewModel() {

    private var _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = arrayListOf<Shoe>(
            Shoe("Skechers", 9.5, "Sketchers", "It's shoe love at first sight with sporty style and comfort in the SKECHERS Summits - Fast Attraction shoe. Soft engineered knit mesh fabric upper in a bungee laced slip on athletic training sneaker with stitching accents. Memory Foam insole."),
            Shoe("Eye Boot", 8.5, "Dr. Martens", "When you think of Dr. Martens, you think of the 1460 8-Eye Boot. This style icon includes all of the authentic Doc Martens touches that have made it a true original. Signature Airwairs leather upper is stiff out of the box and softens over time to conform to the shape of your foot."),
            Shoe("GEL-Contend 6 Running Sneaker", 10.5, "ASICS", "Stay on track to hit your training targets wearing the ASICS Gel-Contend™ 6 Running Sneaker. Featuring the rearfoot GEL® technology, this sneaker for women provides excellent impact absorption. The AMPLIFOAM™ midsole delivers enhanced flexibility and comfort, while the OrthoLite® sockliner wicks away moisture and ensures odor control."),
        )
    }

    fun addShoes(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

}