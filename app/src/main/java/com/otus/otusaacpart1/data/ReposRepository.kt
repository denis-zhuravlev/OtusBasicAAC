package com.otus.otusaacpart1.data

import com.otus.otusaacpart1.data.entity.Repo

import java.util.ArrayList

class ReposRepository {
    private val cachedRepos = ArrayList<Repo>()
    private val fakeRepos = ArrayList<Repo>()

    val cachedOrFakeRepos: List<Repo>
        get() = if (cachedRepos.size > 0)
            cachedRepos
        else
            fakeRepos

    init {
        fakeRepos.add(Repo("mock repo 1"))
        fakeRepos.add(Repo("mock repo 2"))
        fakeRepos.add(Repo("mock repo 3"))
        fakeRepos.add(Repo("mock repo 4"))
    }

    fun addToCache(repos: List<Repo>) {
        this.cachedRepos.addAll(repos)
    }
}
