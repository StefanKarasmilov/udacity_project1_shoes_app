package com.udacity.shoestore.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

const val FIRST_LOGIN_KEY = "first_time_login"

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener {
            navToWelcomeScreen()
        }
        binding.btnSignIn.setOnClickListener {
            navToWelcomeScreen()
        }

        return binding.root
    }

    private fun navToWelcomeScreen() {
//        saveFirstTimeLogin()
        findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
    }

//    private fun saveFirstTimeLogin() {
//        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
//        sharedPref!!.edit {
//            putBoolean(FIRST_LOGIN_KEY, false)
//            commit()
//        }
//    }
    
}