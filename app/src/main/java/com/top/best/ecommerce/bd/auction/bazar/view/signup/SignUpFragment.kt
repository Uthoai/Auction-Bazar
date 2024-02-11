package com.top.best.ecommerce.bd.auction.bazar.view.signup

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.base.BaseFragment
import com.top.best.ecommerce.bd.auction.bazar.databinding.FragmentSignUpBinding
import com.top.best.ecommerce.bd.auction.bazar.isEmpty

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate){
    override fun setListener() {
        with(binding){
            btnSignup.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){
                    if (etName.text.toString().length >= 3){
                        checkEmailPasswordValidity()
                    }
                }else{
                    Toast.makeText(context, "please fill up all", Toast.LENGTH_SHORT).show()
                }
            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }

    private fun checkEmailPasswordValidity() {
        val emailPattern = Regex("^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$")
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (emailPattern.matches(email)){
            if (password.length>=8){
                findNavController().navigate(R.id.action_signUpFragment_to_sellerDashboardFragment)
            }
            else{
                Toast.makeText(context, "enter correct password", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(context, "enter correct email/password", Toast.LENGTH_SHORT).show()
        }
    }

    override fun allObserver() {

    }


}
