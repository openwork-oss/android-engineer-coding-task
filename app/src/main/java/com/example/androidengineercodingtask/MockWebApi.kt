package com.example.androidengineercodingtask

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.mock.BehaviorDelegate

class MockWebApi(
    private val delegate: BehaviorDelegate<WebApi>
) : WebApi {

    override fun postAnswer(answer: AnswerSubmission): Completable {
        return delegate.returningResponse(Any()).postAnswer(answer)
    }

    override fun getAnswers(): Single<List<Answer>> {
        return delegate.returningResponse(answers).getAnswers()
    }
}

private val answers = listOf(
    Answer(
        gender = Gender.MAN,
        ageRange = AgeRange.FROM_20_TO_39,
        date = FormattedDate("2020-05-04"),
        body = "あいうえおかきくけこさしすせそたちつてと\nはひふへほ\n\nまみむめもらりるれろ\nわをん"
    ),
    Answer(
        gender = null,
        ageRange = AgeRange.FROM_60,
        date = FormattedDate("2000-02-29"),
        body = "あいうえおかきくけこさしすせそたちつてと"),
    Answer(
        gender = Gender.WOMAN,
        ageRange = AgeRange.TEENS,
        date = FormattedDate("2019-07-12"),
        body = "あいうえおかきくけこ😊さしすせそたちつてとはひふへほまみむめもらりるれろわをん"
    ),
    Answer(
        gender = Gender.OTHER,
        ageRange = AgeRange.FROM_40_TO_59,
        date = FormattedDate("2013-10-20"),
        body = "あいうえおかきくけこさしすせそたちつてとはひふへほまみむめもらりるれろわをん"
    ),
    Answer(
        gender = Gender.MAN,
        ageRange = null,
        date = FormattedDate("2008-01-01"),
        body = "あいうえおかきくけこさしすせそたちつてとはひふへほまみむめもらりるれろわをん"
    ),
    Answer(
        gender = null,
        ageRange = null,
        date = FormattedDate("2010-12-31"),
        body = "あいうえおかきくけこさしすせそたちつてとはひふへほまみむめもらりるれろわをん"
    )
)
