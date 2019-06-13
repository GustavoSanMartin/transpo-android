/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llamabagel.transpo.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.llamabagel.transpo.ui.search.viewholders.SearchResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class KeyboardState {
    OPEN, CLOSED
}

@FlowPreview
@ExperimentalCoroutinesApi
class SearchViewModel @Inject constructor(
    private val searchUseCase: GetSearchResultsUseCase,
    private val updateQueryUseCase: UpdateQueryUseCase
) : ViewModel() {

    private val _keyboardState = MutableLiveData<KeyboardState>().apply { value = KeyboardState.OPEN }
    val keyboardState: LiveData<KeyboardState> = _keyboardState

    private val _searchResults = MutableLiveData<List<SearchResult>>().apply { value = emptyList() }
    val searchResults: LiveData<List<SearchResult>> = _searchResults

    fun startListeningToSearchResults() = viewModelScope.launch {
        searchUseCase.invoke().collect { _searchResults.postValue(it) }
    }

    fun searchBarFocusChanged(hasFocus: Boolean) {
        if (!hasFocus) _keyboardState.value = KeyboardState.CLOSED
    }

    fun fetchSearchResults(query: CharSequence?) {
        val queryString = query?.toString().orEmpty()

        viewModelScope.launch {

            updateQueryUseCase.invoke(queryString)
        }
    }
}