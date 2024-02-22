package com.top.best.ecommerce.bd.auction.bazar.view.dashboard.seller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.top.best.ecommerce.bd.auction.bazar.R
import com.top.best.ecommerce.bd.auction.bazar.databinding.ActivitySellerDashboardBinding

class SellerDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySellerDashboardBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.sellerFragmentContainerView)
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.storeFragment,
                R.id.toolFragment,
                R.id.dataFragment,
                R.id.messagesFragment,
                R.id.profileFragment,
            )
        )
        binding.sellerBottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfig)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
