package com.example.androidengineercodingtask

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WebApi {
    @POST("answer")
    fun postAnswer(@Body answer: AnswerSubmission): Completable

    @GET("answers")
    fun getAnswers(): Single<List<Answer>>
}
