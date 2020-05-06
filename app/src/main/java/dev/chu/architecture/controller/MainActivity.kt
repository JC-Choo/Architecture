package dev.chu.architecture.controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dev.chu.architecture.R
import dev.chu.architecture.data.Api
import dev.chu.architecture.data.ApiService
import dev.chu.architecture.model.GithubRepos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var mainRv: RecyclerView
    private lateinit var mainPb: ProgressBar

    private lateinit var mainAdapter: MainAdapter
    private lateinit var api: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRv = findViewById(R.id.main_rv)
        mainPb = findViewById(R.id.main_pb)

        mainAdapter = MainAdapter { repo ->
            val text = "${repo.id} - ${repo.name} - ${repo.language}"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        api = Api().createService(ApiService::class.java)
        mainRv.adapter = mainAdapter

        mainPb.visibility = View.VISIBLE
        api.getRepositories()
            .enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.e(TAG, "fail")
                    t.printStackTrace()
                    mainPb.visibility = View.GONE
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    if(response.isSuccessful) {
                        Log.i(TAG, "success")
                        val data = response.body()?.getAsJsonArray("items")
                        val type = object : TypeToken<List<GithubRepos>>() {}.type
                        val result = GsonBuilder().create().fromJson<List<GithubRepos>>(data, type)

                        mainAdapter.setNewItems(result)
                    } else {
                        Log.i(TAG, "not success")
                    }
                    mainPb.visibility = View.GONE
                }
            })
    }
}