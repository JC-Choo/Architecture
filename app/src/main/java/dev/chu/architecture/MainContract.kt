package dev.chu.architecture

import dev.chu.architecture.model.GithubRepos

interface MainContract {
    interface Presenter {
        fun load()
    }

    interface View {
        fun notifyDataChanged(repos: List<GithubRepos>)
    }
}