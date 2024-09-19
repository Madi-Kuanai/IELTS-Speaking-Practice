package com.mk.ielts_speaking_practice.ui.presentation.cueCardScreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.mk.ielts_speaking_practice.domain.model.CueCardModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CueCardActivityViewModel @Inject constructor() : ViewModel() {
    private var _cueCard = MutableStateFlow<CueCardModel?>(null)
    var cueCard = _cueCard.asStateFlow()

    init {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            handleNetworkError(throwable)
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
//            loadData()
//            UpdateRanobeRepositoryImp().fetchRanobeList(getLoginUrl())

        }

    }

    private fun handleNetworkError(throwable: Throwable) {
        // Handle network error
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return CueCardActivityViewModel() as T
            }
        }
    }
}
