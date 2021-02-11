package com.otus.otusaacpart1.domain

import com.otus.otusaacpart1.data.GithubService
import com.otus.otusaacpart1.data.ReposRepository
import com.otus.otusaacpart1.data.entity.Repo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GithubInteractor(private val githubService: GithubService, private val reposRepository: ReposRepository) {

    fun getRepos(username: String, callback: GetRepoCallback) {
        githubService.getUserRepos(username).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if (response.isSuccessful) {
                    reposRepository.addToCache(response.body()!!)

                    callback.onSuccess(reposRepository.cachedOrFakeRepos)
                } else {
                    callback.onError(response.code().toString() + "")
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                callback.onError("Network error probably...")
            }
        })
    }

    interface GetRepoCallback {
        fun onSuccess(repos: List<Repo>)
        fun onError(error: String)
    }
}
