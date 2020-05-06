package dev.chu.architecture.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.chu.architecture.data.repository.MainRepository
import dev.chu.architecture.model.GithubRepos

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private var _repos = MutableLiveData<List<GithubRepos>>()
    val repos: LiveData<List<GithubRepos>>
        get() = _repos

    val loading: LiveData<Boolean>
        get() = repository.loading

    init {
        _repos = repository.load() as MutableLiveData<List<GithubRepos>>
    }
}