/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llambagel.transpo.search.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.llambagel.transpo.search.R
import ca.llambagel.transpo.search.di.inject
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}

class SearchActivityLauncher @Inject constructor(private val activity: Activity) {
    fun launch() {
        activity.startActivity(Intent(activity, SearchActivity::class.java))
    }
}