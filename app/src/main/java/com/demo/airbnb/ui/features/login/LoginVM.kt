package com.demo.airbnb.ui.features.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.usecases.account.ISignInUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(private val signInUC: ISignInUC) : ViewModel() {
    data class UIState(
        val session: Session? = null,
        val exception: Exception? = null,
        val isLoading: Boolean = false
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState

    fun signIn(email: String, password: String) {
        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val session = signInUC.execute(email, password)
                _uiState.value = _uiState.value.copy(session = session, isLoading = false)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
        }
    }
}