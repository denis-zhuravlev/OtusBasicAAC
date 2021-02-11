package com.otus.otusaacpart1.data

import com.otus.otusaacpart1.data.entity.Repo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    fun getUserRepos(@Path("user") user: String): Call<List<Repo>>
}
