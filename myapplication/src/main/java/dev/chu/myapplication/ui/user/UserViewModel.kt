package dev.chu.myapplication.ui.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import dev.chu.myapplication.data.UserService
import dev.chu.myapplication.data.entity.User
import dev.chu.myapplication.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class UserViewModel @Inject constructor(
    application: Application,
    userService: UserService,
    @Named("errorEvent") errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application) {

    private val userService: UserService
    private val errorEvent: SingleLiveEvent<Throwable>

    private val compositeDisposable = CompositeDisposable()
    private val liveItem = MutableLiveData<User>()

    val name: LiveData<String> = Transformations.map(liveItem) { input -> input.name }
    val email: LiveData<String> = Transformations.map(liveItem) { input -> input.email }
    val homepage: LiveData<String> = Transformations.map(liveItem) { input -> input.website }
    val phone: LiveData<String> = Transformations.map(liveItem) { input -> input.phone }
    val location: LiveData<String> = Transformations.map(liveItem) { input -> input.address.toString() }

    private val _loading = MutableLiveData(true)

    val loading: LiveData<Boolean> get() = _loading

    init {
        Timber.d("UserViewModel created")
        this.userService = userService
        this.errorEvent = errorEvent
    }

    fun loadUser(userId: Long) {
        compositeDisposable.add(userService.getUser(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { item -> _loading.postValue(false) }
            .subscribe(liveItem::setValue, errorEvent::setValue))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
