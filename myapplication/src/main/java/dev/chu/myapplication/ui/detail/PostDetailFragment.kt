package dev.chu.myapplication.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import dev.chu.myapplication.databinding.FragmentPostDetailBinding
import dev.chu.myapplication.di.AppViewModelFactory
import javax.inject.Inject

/**
 * 게시 글 상세 화면
 */

class PostDetailFragment : DaggerFragment() {
    @Inject
    private lateinit var binding: FragmentPostDetailBinding

    @Inject
    private lateinit var adapter: PostDetailAdapter

    @Inject
    private lateinit var layoutManager: LinearLayoutManager

    @Inject
    private lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    private lateinit var navController: Lazy<NavController>

    private lateinit var viewModel: PostDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostDetailViewModel::class.java]

        if (savedInstanceState == null) {
            // Post 객체를 전달받는다.
            val args: PostDetailFragmentArgs = PostDetailFragmentArgs.fromBundle(arguments)
            viewModel.load(args.getPost())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager
        binding.viewModel = viewModel
        viewModel.liveItems.observe(viewLifecycleOwner, Observer { items ->
            adapter.setNewItems(items)
        })
        viewModel.userClickEvent.observe(
            viewLifecycleOwner,
            Observer { userId: Long? ->
                navController.value.navigate(
                    PostDetailFragmentDirections.actionPostDetailFragmentToUserFragment(userId)
                )
            }
        )
    }
}