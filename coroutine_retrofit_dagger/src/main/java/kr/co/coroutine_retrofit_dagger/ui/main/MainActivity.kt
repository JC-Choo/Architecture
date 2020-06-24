package kr.co.coroutine_retrofit_dagger.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_dog_of_the_day.view.*
import kr.co.coroutine_retrofit_dagger.R
import kr.co.coroutine_retrofit_dagger.data.Status
import kr.co.coroutine_retrofit_dagger.data.entity.Dog
import kr.co.coroutine_retrofit_dagger.util.ImageLoader
import javax.inject.Inject

// https://medium.com/@shivamdhuria/learn-by-doing-coroutines-a-guide-for-using-coroutines-in-android-for-retrofit-requests-eaef6ca58c7e

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
//                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        setRecyclerView()
        subscribeObservers()

        viewModel.loadDogListAsync()
    }

    private fun setRecyclerView() {
        recycler.adapter = adapter
    }

    private fun subscribeObservers() {
        viewModel.loading.observe(this, Observer {
            main_pb.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.status.observe(this, Observer { it ->
            time.text = it
        })

        viewModel.snackbar.observe(this, Observer { text ->
            text?.let {
                Snackbar.make(root_layout, text, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarShown()
            }
        })

        viewModel.dogList.observe(this, Observer {
            val list = it as List<Dog>
            adapter.submitList(list)
        })

        viewModel.liveDataResult.observe(this, Observer {
            Log.e("liveDataResult", it.toString())
            when (it) {
                is Status.Loading -> {
                    showLoadingStatus(it.loading)
                }
                is Status.Success<*> -> {
                    showLoadingStatus(false)
                    updateTopTwoDogs(it.data as List<Dog>)
                }
                is Status.Error -> {
                }
            }
        })
    }

    private fun showLoadingStatus(loading: Boolean) {
        statusTop.text = if (loading) "Loading..." else "Finished"
    }

    private fun updateTopTwoDogs(list: List<Dog>) {
        list[0].let {
            dog_one.breed_name.text = it.breed
            it.imageUrl?.let { it1 -> ImageLoader.loadImage(this, it1, dog_one.episode_item_image) }
        }

        list[1].let {
            dog_two.breed_name.text = it.breed
            it.imageUrl?.let { it1 -> ImageLoader.loadImage(this, it1, dog_two.episode_item_image) }
        }
    }
}
