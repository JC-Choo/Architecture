package dev.chu.myapplication.ui.post

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.chu.myapplication.data.PostService
import dev.chu.myapplication.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class PostViewModel @Inject constructor(
    application: Application,
    postService: PostService,
    @Named("errorEvent") errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application), PostItem.EventListener {

    private val postService: PostService
    private val errorEvent: SingleLiveEvent<Throwable>

    // RecyclerView에 표현할 아이템들을 LiveData로 관리
    private val _livePosts: MutableLiveData<List<PostItem>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var _loading: MutableLiveData<Boolean> = MutableLiveData(true)

    // 게시글 아이템 클릭 이벤트를 관리
    private val _postClickEvent: SingleLiveEvent<PostItem> = SingleLiveEvent()

    val livePosts: LiveData<List<PostItem>> get() = _livePosts
    val loading: LiveData<Boolean> get() = _loading

    init {
        Timber.d("PostViewModel created")
        // 오브젝트 그래프로부터 생성자 주입
        this.postService = postService
        this.errorEvent = errorEvent
    }

    // 게시글 목록 불러오기
    fun loadPosts() {
        compositeDisposable.add(postService.getPosts()
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .map { post -> PostItem(post, this) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { _loading.postValue(false) }
            .subscribe(_livePosts::setValue, errorEvent::setValue))
    }

    /**
     * ViewModel은 생명 주기를 알고 동작한다.
     * 뷰 모델이 파괴될 때, RxJava의 Disposable 과 같은 리소스 등을 해제할 수 있또록 한다.
     */
    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
        compositeDisposable.dispose()
    }

    /**
     * PostItem 클릭 이벤트 구현
     */
    override fun onPostClick(postItem: PostItem) {
        // Fragment로 이벤트를 전달하도록, SingleLiveEvent의 값을 변경한다.
        _postClickEvent.value = postItem
    }
    // PostFragment 로 postClickEvent 변수를 노출
    fun getPostClickEvent(): SingleLiveEvent<PostItem> = _postClickEvent
}
