package uz.kattabozor.task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.kattabozor.task.utils.Constants
import uz.kattabozor.task.utils.Constants.OKHTTP_TIMEOUT
import uz.kattabozor.task.extensions.addLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideClient() = OkHttpClient().newBuilder().retryOnConnectionFailure(false)
        .connectTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS).addLoggingInterceptor().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) =
        Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()

}

