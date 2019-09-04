package com.robelseyoum3.startwarsretrofitobserver.presenter

import android.util.Log
import com.robelseyoum3.startwarsretrofitobserver.PresenterInterface
import com.robelseyoum3.startwarsretrofitobserver.ViewInterface
import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource
import com.robelseyoum3.startwarsretrofitobserver.network.MovieRequest
import com.robelseyoum3.startwarsretrofitobserver.network.RetrofitInstances
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Presenter(_view: ViewInterface): PresenterInterface  {

    private var view: ViewInterface? = _view
    private lateinit var model: MovieSource
    var compositeDisposable = CompositeDisposable() //we can add several observable


    override fun getStartWarActors() {
        makeRetrofitObserverCall()
    }

    private fun makeRetrofitObserverCall(){

        val movieRequest = RetrofitInstances().retrofitInstances.create(MovieRequest::class.java)
        val call = movieRequest.getActors()

        compositeDisposable.add(

            call.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)

        )

    }

    private fun handleResponse(movieSource: MovieSource) {
        val res = movieSource.results
        Log.i("Actor Name ", ""+res[0].name)
        view?.showActors(movieSource)
    }


    private fun handleError(error: Throwable) {
        Log.d("Actors Error ", ""+error.message)
    }


    override fun onDestroy() {
        view = null
        compositeDisposable.clear()
    }

}