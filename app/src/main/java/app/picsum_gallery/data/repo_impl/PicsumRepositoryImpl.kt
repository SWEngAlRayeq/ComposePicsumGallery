package app.picsum_gallery.data.repo_impl

import app.picsum_gallery.data.remote.PicsumApi
import app.picsum_gallery.domain.model.PicsumImage
import app.picsum_gallery.domain.repo.PicsumRepository
import javax.inject.Inject

class PicsumRepositoryImpl @Inject constructor(
    private val api: PicsumApi
): PicsumRepository {
    override suspend fun getImages(): List<PicsumImage> {
        return api.getImages().map {
            it.toPicsumImage()
        }
    }
}