package com.example.mo2o.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat


fun <T> Activity.openActivity(activity: Class<T>,optionsCompat: ActivityOptionsCompat, extras: Bundle.() -> Unit = {}) {
    var intent = Intent(this, activity)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent,optionsCompat.toBundle())
}