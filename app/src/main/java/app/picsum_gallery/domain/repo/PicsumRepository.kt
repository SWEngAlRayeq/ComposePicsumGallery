package app.picsum_gallery.domain.repo

import app.picsum_gallery.domain.model.PicsumImage

interface PicsumRepository {

    suspend fun getImages(): List<PicsumImage>

}