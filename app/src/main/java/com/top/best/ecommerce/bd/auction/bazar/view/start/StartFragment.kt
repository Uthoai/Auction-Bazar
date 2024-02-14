package com.top.best.ecommerce.bd.auction.bazar.view.start

import androidx.navigation.fragment.findNavController
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.base.BaseFragment
import com.top.best.ecommerce.bd.auction.bazar.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {
    override fun setListener() {
        with(binding){
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnSignup.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_signUpFragment)
            }
        }
    }

    override fun allObserver() {

    }
}
