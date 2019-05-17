/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llambagel.transpo.search.di

import ca.llamabagel.transpo.di.BaseActivityComponent
import ca.llamabagel.transpo.di.CoreComponent
import ca.llamabagel.transpo.di.scope.FeatureScope
import ca.llambagel.transpo.search.ui.SearchActivity
import dagger.Component

@FeatureScope
@Component(modules = [SearchModule::class], dependencies = [CoreComponent::class])
abstract class SearchComponent : BaseActivityComponent<SearchActivity> {

    @Component.Builder
    interface Builder {
        fun build(): SearchComponent

        fun coreComponent(component: CoreComponent): Builder
    }
}