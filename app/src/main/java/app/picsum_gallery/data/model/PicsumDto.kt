package app.picsum_gallery.data.model

import app.picsum_gallery.domain.model.PicsumImage

data class PicsumDto(
    val id: String,
    val author: String,
    val download_url: String
){
    fun toPicsumImage() = PicsumImage(id, author, download_url)
}