package com.otus.otusaacpart1

import android.app.Application

import com.google.gson.Gson
import com.otus.otusaacpart1.data.GithubService
import com.otus.otusaacpart1.data.ReposRepository
import com.otus.otusaacpart1.domain.GithubInteractor
import com.otus.otusaacpart1.domain.GithubReposUpdater

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var githubService: GithubService
    lateinit var githubReposUpdater: GithubReposUpdater
    lateinit var githubInteractor: GithubInteractor
    var reposRepository = ReposRepository()

    override fun onCreate() {
        super.onCreate()

        instance = this

        initRetrofit()
        initInteractor()
    }

    private fun initInteractor() {
        githubInteractor = GithubInteractor(githubService, reposRepository)
    }

    private fun initRetrofit() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        githubService = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(GithubService::class.java!!)

        githubReposUpdater = GithubReposUpdater(githubService)
    }

    companion object {
        var instance: App? = null
            private set
    }
}
