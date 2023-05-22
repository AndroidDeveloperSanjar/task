package uz.kattabozor.task.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.kattabozor.task.domain.usecase.OfferUseCase
import uz.kattabozor.task.extensions.errorEntity
import uz.kattabozor.task.presentation.model.offer.UIOfferModel
import uz.kattabozor.task.utils.ErrorEntity
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val offerUseCase: OfferUseCase
) : ViewModel() {

    private val _offers = MutableStateFlow<UIState>(UIState.Loading)
    val offers = _offers.asStateFlow()

    fun getOffers() {
        offerUseCase().onEach {
            it?.let { uiData ->
                _offers.value = UIState.Success(uiData)
            }
        }.catch {
            _offers.value = UIState.Error(it.errorEntity())
        }.launchIn(viewModelScope)
    }

}

sealed class UIState {
    object Loading : UIState()
    data class Success(
        val uiData: UIOfferModel
    ) : UIState()

    data class Error(
        val errorEntity: ErrorEntity
    ) : UIState()
}