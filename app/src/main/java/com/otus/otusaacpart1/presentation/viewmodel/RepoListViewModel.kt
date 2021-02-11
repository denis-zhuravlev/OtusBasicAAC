package com.otus.otusaacpart1.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.otus.otusaacpart1.App
import com.otus.otusaacpart1.data.entity.Repo
import com.otus.otusaacpart1.domain.GithubInteractor

class RepoListViewModel : ViewModel() {
    init {
        Log.d("viewModel", this.toString())
    }
    private val reposLiveData = MutableLiveData<List<Repo>>()
    private val errorLiveData = MutableLiveData<String>()
    private val selectedRepoUrlLiveData = MutableLiveData<String>()

    // LiveData -> BehaviourSubject

    private val githubInteractor = App.instance!!.githubInteractor

    val repos: LiveData<List<Repo>>
        get() = reposLiveData

    val error: LiveData<String>
        get() = errorLiveData

    val selectedRepoUrl: LiveData<String>
        get() = selectedRepoUrlLiveData

    fun onGetDataClick() {
        githubInteractor.getRepos("octocat", object : GithubInteractor.GetRepoCallback {
            override fun onSuccess(repos: List<Repo>) {
                reposLiveData.postValue(repos)
            }

            override fun onError(error: String) {
                errorLiveData.postValue(error)
            }
        })
    }

    fun onRepoSelect(repoUrl: String) {
        selectedRepoUrlLiveData.postValue(repoUrl)
    }

}
