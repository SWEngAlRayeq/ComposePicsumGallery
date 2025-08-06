package app.picsum_gallery.di

import app.picsum_gallery.data.remote.PicsumApi
import app.picsum_gallery.data.repo_impl.PicsumRepositoryImpl
import app.picsum_gallery.domain.repo.PicsumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun providePicsumApi(client: OkHttpClient): PicsumApi {
        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicsumApi::class.java)
    }

    @Provides
    fun providePicsumRepository(api: PicsumApi): PicsumRepository {
        return PicsumRepositoryImpl(api)
    }


}