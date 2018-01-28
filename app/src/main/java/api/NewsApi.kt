package api

import ldimitrov.com.cryptonewsreader.BuildConfig
import ldimitrov.com.cryptonewsreader.api.model.ArticleResponse
import ldimitrov.com.cryptonewsreader.api.model.SourceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("articles")
    fun getAtricles(@Query("source") source: String,
                    @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY): Call<ArticleResponse>

    @GET("sources")
    fun getSources(@Query("category") category: String,
                   @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY,
                   @Query("language") language: String = "en"): Call<SourceResponse>

}