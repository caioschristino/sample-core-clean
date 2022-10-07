package com.v2.sample.clean

import android.os.Bundle
import br.com.clean.core.view.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LandingFragment.newInstance())
                .commitNow()
        }
    }
}