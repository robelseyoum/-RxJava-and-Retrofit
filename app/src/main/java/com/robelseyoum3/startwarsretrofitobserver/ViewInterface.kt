package com.robelseyoum3.startwarsretrofitobserver

import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource

interface ViewInterface {

    fun showLoading()
    fun showActors(actor: MovieSource)
}