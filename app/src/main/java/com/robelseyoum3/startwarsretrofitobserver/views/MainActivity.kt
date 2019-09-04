package com.robelseyoum3.startwarsretrofitobserver.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.robelseyoum3.startwarsretrofitobserver.R
import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource
import com.robelseyoum3.startwarsretrofitobserver.network.MovieRequest
import com.robelseyoum3.startwarsretrofitobserver.network.RetrofitInstances
import com.robelseyoum3.startwarsretrofitobserver.views.fragmentviews.StartFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()

    }

    private fun addFragment(){
        var fragmentManager = supportFragmentManager
        var fragmetTransaction = fragmentManager.beginTransaction()

        fragmetTransaction.add(R.id.fragment_container_from_main, StartFragment())
            //  .addToBackStack(null)
            .commit()
    }

}
