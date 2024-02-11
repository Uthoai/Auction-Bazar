package com.top.best.ecommerce.bd.auction.bazar

import android.widget.EditText

fun EditText.isEmpty(): Boolean{
    return if (this.text.toString().isEmpty()){
        this.error = "This filled need to be fill up"
        true
    }
    else{
        false
    }
}
