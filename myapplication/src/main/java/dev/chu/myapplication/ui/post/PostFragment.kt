package dev.chu.myapplication.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Lazy
import dagger.android.support.DaggerFragment
import dev.chu.myapplication.databinding.FragmentPostBinding
import dev.chu.myapplication.di.AppViewModelFactory
import javax.inject.Inject

/**
 * 게시 글 화면 구성하기
 * 멤버 인젝션을 위해 DaggerFragment 상속
 */
class PostFragment: DaggerFragment() {
    /**
     * 오브젝트 그래프로부터 멤버 인젝션
     */
    @Inject
    lateinit var binding: FragmentPostBinding
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    @Inject
    lateinit var adapter: PostAdapter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var navController: Lazy<NavController>

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel 객체를 요청
        viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        if(savedInstanceState == null) {
            // 데이터 요청, 프래그먼트가 재생성되었을 때는 요청하지 않는다.
            viewModel.loadPosts()
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
        // Lifecycle Owner 등록
        binding.lifecycleOwner = viewLifecycleOwner
        // RecyclerView Adapter 지정
        binding.recyclerView.adapter = adapter
        // RecyclerView 레이아웃 매니져 지정
        binding.recyclerView.layoutManager = layoutManager
        // 바인딩 클래스에 ViewModel 연결
        binding.viewModel = viewModel

        // ViewModel이 가진 게시 글 목록을 구독하여 Adapter에 반영
        viewModel.livePosts.observe(viewLifecycleOwner, Observer { list ->
            adapter.setItems(list)
        })

        // 게시 글이 클릭되었을 때 게시 글 상세 화면 목적지로 이동
        viewModel.postClickEvent.observe(viewLifecycleOwner, Observer { postItem ->
            navController.get().navigate(PostFragmentDirections
                .actionPostFragmentToPostDetailFragment(postItem.post))
        })
    }
}