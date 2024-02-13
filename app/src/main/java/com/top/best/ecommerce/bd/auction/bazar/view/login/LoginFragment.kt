package com.top.best.ecommerce.bd.auction.bazar.view.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.base.BaseFragment
import com.top.best.ecommerce.bd.auction.bazar.core.DataState
import com.top.best.ecommerce.bd.auction.bazar.databinding.FragmentLoginBinding
import com.top.best.ecommerce.bd.auction.bazar.isEmpty

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    val viewModel: LoginViewModel by viewModels()
    override fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()
                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    checkEmailPasswordValidity()
                }else{
                    Toast.makeText(context, "please fill up email/password", Toast.LENGTH_SHORT).show()
                }
            }
            btnSignup.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        }
    }

    private fun checkEmailPasswordValidity() {
        val emailPattern = Regex("^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$")
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (emailPattern.matches(email)){
            if (password.length>=8){
                val user = UserLogin(
                    email,
                    password
                )
                viewModel.userLogin(user)
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
        loginObserver()
    }

    private fun loginObserver() {
        viewModel.loginResponse_.observe(viewLifecycleOwner){
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
                    findNavController().navigate(R.id.action_loginFragment_to_sellerDashboardFragment)
                }
            }
        }
    }
}
