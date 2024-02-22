package com.top.best.ecommerce.bd.auction.bazar.view.signup

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.base.BaseFragment
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.databinding.FragmentSignUpBinding
import com.top.best.ecommerce.bd.auction.bazar.isEmpty
import com.top.best.ecommerce.bd.auction.bazar.view.dashboard.seller.SellerDashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate){

    private val viewModel: SignUpViewModel by viewModels()
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
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (emailPattern.matches(email)){
            if (password.length>=8){
                val user = UserSignUp(
                    name,
                    email,
                    password,
                    "Seller",
                    ""
                )
                viewModel.userSignup(user)
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
        signupObserver()
    }
    private fun signupObserver() {
        viewModel.signupResponse_.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    startActivity(Intent(requireContext(), SellerDashboardActivity::class.java))
                    requireActivity().finish()
                }
            }
        }
    }

}
