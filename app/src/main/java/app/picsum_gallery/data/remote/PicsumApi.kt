package app.picsum_gallery.data.remote

import app.picsum_gallery.data.model.PicsumDto
import retrofit2.http.GET

interface PicsumApi {

    @GET("v2/list")
    suspend fun getImages(): List<PicsumDto>

}