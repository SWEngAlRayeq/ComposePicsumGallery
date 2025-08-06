package app.picsum_gallery.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.picsum_gallery.domain.model.PicsumImage
import app.picsum_gallery.domain.usecase.GetPicsumImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PicsumViewModel @Inject constructor(
    private val useCase: GetPicsumImagesUseCase
) : ViewModel() {

    var images by mutableStateOf<List<PicsumImage?>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set


    init {
        fetchImages()
    }

    private fun fetchImages() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                images = useCase()
            } catch (e: Exception) {
                error = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }
}