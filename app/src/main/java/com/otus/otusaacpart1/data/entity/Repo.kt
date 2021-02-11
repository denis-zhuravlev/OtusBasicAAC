package com.otus.otusaacpart1.data.entity

import com.google.gson.annotations.SerializedName

class Repo {

    @SerializedName("git_url")
    lateinit var gitUrl: String

    constructor() {}

    constructor(gitUrl: String) {
        this.gitUrl = gitUrl
    }
}
