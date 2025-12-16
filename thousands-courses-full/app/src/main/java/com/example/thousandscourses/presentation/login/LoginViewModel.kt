@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val email = MutableStateFlow("")
    private val password = MutableStateFlow("")

    val isLoginEnabled: StateFlow<Boolean> =
        combine(email, password) { e, p ->
            isEmailValid(e) && p.isNotBlank()
        }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

    fun onEmailChanged(value: String) {
        email.value = value
    }

    fun onPasswordChanged(value: String) {
        password.value = value
    }

    private fun isEmailValid(email: String): Boolean {
        val regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return regex.matches(email)
    }
}