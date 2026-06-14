package com.example.userprofilekmp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val user: User, val deviceName: String) : UserUiState()
    data class Error(val message: String) : UserUiState()
}

class UserViewModel(private val userRepo: UserRepository) {
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val jobScope = CoroutineScope(Dispatchers.Main)

    fun fetchUser(userId: Int) {
        jobScope.launch {
            _uiState.value = UserUiState.Loading
            try {
                val data = userRepo.getUser(userId)
                val platformInfo = getPlatform().deviceName
                _uiState.value = UserUiState.Success(data, platformInfo)
            } catch (err: Exception) {
                _uiState.value = UserUiState.Error(err.message ?: "An error occurred while fetching user profile")
            }
        }
    }
}
