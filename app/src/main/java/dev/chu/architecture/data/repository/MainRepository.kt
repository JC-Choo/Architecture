package dev.chu.architecture.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dev.chu.architecture.data.remote.Api
import dev.chu.architecture.data.remote.ApiService
import dev.chu.architecture.model.GithubRepos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private val TAG = MainRepository::class.java.simpleName
    private val api = Api().createService(ApiService::class.java)

    var loading = MutableLiveData(false)

    fun load(): LiveData<List<GithubRepos>> {
        val repos = MutableLiveData<List<GithubRepos>>()
        loading.postValue(true)

        api.getRepositories()
            .enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.e(TAG, "fail")
                    t.printStackTrace()
                    loading.postValue(false)
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    if(response.isSuccessful) {
                        Log.i(TAG, "success")
                        val data = response.body()?.getAsJsonArray("items")
                        val type = object : TypeToken<List<GithubRepos>>() {}.type
                        val result = GsonBuilder().create().fromJson<List<GithubRepos>>(data, type)

                        repos.postValue(result)
                    } else {
                        Log.i(TAG, "not success")
                    }
                    loading.postValue(false)
                }
            })

        return repos
    }

}