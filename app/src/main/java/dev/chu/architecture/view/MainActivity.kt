package dev.chu.architecture.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dev.chu.architecture.MainContract
import dev.chu.architecture.R
import dev.chu.architecture.data.Api
import dev.chu.architecture.data.ApiService
import dev.chu.architecture.model.GithubRepos
import dev.chu.architecture.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var mainRv: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRv = findViewById(R.id.main_rv)
        mainAdapter = MainAdapter { repo ->
            val text = "${repo.id} - ${repo.name} - ${repo.language}"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        presenter = MainPresenter(this, Api().createService(ApiService::class.java))
        presenter.load()

        mainRv.adapter = mainAdapter
    }

    override fun notifyDataChanged(repos: List<GithubRepos>) {
        mainAdapter.setNewItems(repos)
    }
}