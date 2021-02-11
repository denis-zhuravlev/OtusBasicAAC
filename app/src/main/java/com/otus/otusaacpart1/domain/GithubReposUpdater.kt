package com.otus.otusaacpart1.domain


import android.os.Handler
import android.util.Log

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

import com.otus.otusaacpart1.data.GithubService
import com.otus.otusaacpart1.data.entity.Repo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*

class GithubReposUpdater(private val service: GithubService) : LifecycleObserver {
    private val handler = Handler()

    private val taskRunnable = object: Runnable {
        override fun run() {
            service.getUserRepos("octocat").enqueue(object : Callback<List<Repo>> {
                override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                    handler.postDelayed(this@GithubReposUpdater.taskRunnable, DELAY.toLong())
                }

                override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

                }
            })
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onLifecycleResume() {
        Log.d(TAG, "onResume")

        handler.postDelayed(taskRunnable, DELAY.toLong())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onLifecyclePaused() {
        Log.d(TAG, "onPause")


        handler.removeCallbacksAndMessages(null)
    }

    companion object {
        private val TAG = "GithubReposUpdater"
        private val DELAY = 5000
    }
}*/
