package com.mindorks.bootcamp.learndagger.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.model.Dummy
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.data.remote.Networking
import com.mindorks.bootcamp.learndagger.data.remote.dummyrequest.DummyRequest
import com.mindorks.bootcamp.learndagger.data.remote.dummyresponse.DummyResponse
import com.mindorks.bootcamp.learndagger.di.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) {

    companion object {
        val TAG: String = "MainViewModel"
    }

    val dummies = MutableLiveData<List<Dummy>>()


    fun getDummies() {
        compositeDisposable.add(
                networkService.doDummycall(
                        DummyRequest(2345)
                ).subscribeOn(Schedulers.io())
                        .subscribe({
                            dummies.postValue(it.data)
                        }, {
                            Log.d(TAG, "Something happened error")
                        })
        )
    }


    fun onDestory(){
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }


}
