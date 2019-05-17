/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llambagel.transpo.search.di

import ca.llamabagel.transpo.coreComponent
import ca.llambagel.transpo.search.ui.SearchActivity

fun inject(activity: SearchActivity) {
    DaggerSearchComponent.builder()
        .coreComponent(activity.coreComponent())
        .build()
        .inject(activity)
}