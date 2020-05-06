package dev.chu.architecture.presenter

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dev.chu.architecture.MainContract
import dev.chu.architecture.data.ApiService
import dev.chu.architecture.model.GithubRepos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(
    private val view: MainContract.View,
    private val api: ApiService
) : MainContract.Presenter {

    private val TAG = MainPresenter::class.java.simpleName

    override fun load() {
        view.showProgress()
        api.getRepositories()
            .enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.e(TAG, "fail")
                    t.printStackTrace()
                    view.hideProgress()
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    if(response.isSuccessful) {
                        Log.i(TAG, "success")
                        val data = response.body()?.getAsJsonArray("items")
                        val type = object : TypeToken<List<GithubRepos>>() {}.type
                        val result = GsonBuilder().create().fromJson<List<GithubRepos>>(data, type)

                        view.notifyDataChanged(result)
                    } else {
                        Log.i(TAG, "not success")
                    }
                    view.hideProgress()
                }
            })
    }

}