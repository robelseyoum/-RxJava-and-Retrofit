package com.robelseyoum3.startwarsretrofitobserver.network

import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRequest {

    //https://swapi.co/api/people/

    @GET("people")
    fun getActors(): Observable<MovieSource>


}