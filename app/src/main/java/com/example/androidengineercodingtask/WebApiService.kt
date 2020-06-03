package com.example.androidengineercodingtask

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit

class WebApiService {

    companion object {
        fun create(): WebApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            val behavior = NetworkBehavior.create().apply {
                setDelay(1L, TimeUnit.SECONDS)
            }

            val mockRetrofit = MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build()

            val delegate = mockRetrofit.create(WebApi::class.java)

            return MockWebApi(delegate)
        }
    }
}
