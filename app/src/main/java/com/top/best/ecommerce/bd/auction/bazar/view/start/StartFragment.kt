package com.top.best.ecommerce.bd.auction.bazar.view.start

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.base.BaseFragment
import com.top.best.ecommerce.bd.auction.bazar.databinding.FragmentStartBinding
import com.top.best.ecommerce.bd.auction.bazar.view.dashboard.seller.SellerDashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {
    override fun setListener() {

        setAutoLogin()

        with(binding){
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnSignup.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_signUpFragment)
            }
        }
    }

    private fun setAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let {
            startActivity(Intent(requireContext(),SellerDashboardActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun allObserver() {

    }
}
