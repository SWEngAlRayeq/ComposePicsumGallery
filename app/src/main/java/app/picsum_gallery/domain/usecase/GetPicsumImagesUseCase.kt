package app.picsum_gallery.domain.usecase

import app.picsum_gallery.domain.model.PicsumImage
import app.picsum_gallery.domain.repo.PicsumRepository
import javax.inject.Inject

class GetPicsumImagesUseCase @Inject constructor(
    private val repository: PicsumRepository
) {
    suspend operator fun invoke(): List<PicsumImage> = repository.getImages()
}