package com.example.mo2o.ui.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mo2o.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        configureView()
        if(!intent.extras.getString(getString(R.string.THUMBNAIL_EXTRA_INTENT)).isEmpty())
            loadImageTransition()
    }

    private fun loadImageTransition() {
        postponeEnterTransition();
        Picasso.get()
            .load(intent.extras.getString(getString(R.string.THUMBNAIL_EXTRA_INTENT)))
            .fit()
            .noFade()
            .into(findViewById<ImageView>(R.id.iv_recepy), object : Callback{
                override fun onSuccess() {
                    startPostponedEnterTransition();
                }

                override fun onError(e: Exception?) {

                }
            })
    }

    private fun configureView() {
        findViewById<TextView>(R.id.tv_title).text = intent.extras.getString(getString(R.string.TITLE_EXTRA_INTENT))
        findViewById<TextView>(R.id.tv_ingredients).text = intent.extras.getString(getString(R.string.INGREDIENTS_EXTRA_INTENT))
        findViewById<TextView>(R.id.tv_link).text = intent.extras.getString(getString(R.string.HREF_EXTRA_INTENT))
    }


}
