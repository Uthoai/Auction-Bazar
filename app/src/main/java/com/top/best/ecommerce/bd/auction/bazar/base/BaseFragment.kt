package com.top.best.ecommerce.bd.auction.bazar.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>
    (private val bindingInflater: (inflater: LayoutInflater)-> VB)
    : Fragment()
{
    private var _binding: VB? = null
    val binding get() = _binding as VB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)

        return binding.root
    }
    abstract fun setListener()
    abstract fun allObserver()
}