package dev.chu.myapplication.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.chu.myapplication.data.CommentService
import dev.chu.myapplication.data.UserService
import dev.chu.myapplication.data.entity.Comment
import dev.chu.myapplication.data.entity.Post
import dev.chu.myapplication.data.entity.User
import dev.chu.myapplication.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Function3
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class PostDetailViewModel @Inject constructor(
    application: Application,
    userService: UserService,
    commentService: CommentService,
    @Named("errorEvent") errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application), PostDetailUserItem.EventListener {

    private val _liveItems = MutableLiveData<List<PostDetailItem>>()
    private val compositeDisposable = CompositeDisposable()

    private val userService: UserService
    private val commentService: CommentService
    private val errorEvent: SingleLiveEvent<Throwable>

    private val _loading = MutableLiveData(true)
    private val _userClickEvent = SingleLiveEvent<Long>()

    val liveItems: LiveData<List<PostDetailItem>> get() = _liveItems
    val loading: LiveData<Boolean> get() = _loading
    val userClickEvent: LiveData<Long> get() = _userClickEvent

    init {
        Timber.d("PostDetailViewModel created")
        this.userService = userService
        this.commentService = commentService
        this.errorEvent = errorEvent
    }

    fun load(post: Post) {
        compositeDisposable.add(
            Single.zip(
                userService.getUser(post.userId),
                Single.just(post),
                commentService.getComments(post.id),
                Function3<User, Post, List<Comment>, List<PostDetailItem>> { user, p, comments ->
                    val list: MutableList<PostDetailItem> = mutableListOf()
                    list.add(PostDetailUserItem(user, this))
                    list.add(PostDetailPostItem(p))
                    for (comment in comments) {
                        list.add(PostDetailCommentItem(comment))
                    }

                    list
                })
                .retry(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { _loading.postValue(false) }
                .subscribe(_liveItems::setValue, errorEvent::setValue)
        )
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
        compositeDisposable.dispose()
    }

    override fun onUserClick(userId: Long) {
        _userClickEvent.value = userId
    }

}