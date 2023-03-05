package com.example.glidegiphy.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glidegiphy.data.remote.GifApi
import com.example.glidegiphy.data.remote.ResponseGif.Data
import com.example.glidegiphy.data.remote.ResponseGif.ResponseGif
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: GifApi
) : ViewModel() {

    private val gifsLiveData = MutableLiveData<ResponseGif>()
    private val textToSearchLiveData = MutableLiveData<String>()

    val gifs: LiveData<ResponseGif> = gifsLiveData
    private val textToSearch: LiveData<String> = textToSearchLiveData

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val restaurants = api.getData(textToSearch.value!!)
                gifsLiveData.value = restaurants
            }
        }
    }

    fun setTextToSearch(_textToSearch: String) {
        textToSearchLiveData.value = _textToSearch
        getData()
    }

    fun getTextToSearch(): String = textToSearch.value.toString()

    fun getPreloadedGifs(): List<Data> = gifs.value!!.data

}