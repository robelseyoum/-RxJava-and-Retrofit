package com.robelseyoum3.startwarsretrofitobserver.views.fragmentviews


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.lruCache
import androidx.recyclerview.widget.LinearLayoutManager

import com.robelseyoum3.startwarsretrofitobserver.R
import com.robelseyoum3.startwarsretrofitobserver.ViewInterface
import com.robelseyoum3.startwarsretrofitobserver.models.MovieSource
import com.robelseyoum3.startwarsretrofitobserver.presenter.Presenter
import kotlinx.android.synthetic.main.fragment_start.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class StartFragment : Fragment() , ViewInterface {

    private lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        presenter.getStartWarActors()

    }


    override fun showLoading() {
        progress_id_main.visibility = View.VISIBLE

    }

    override fun showActors(actor: MovieSource) {
        progress_id_main.visibility = View.GONE

        val adaptor = ActorAdaptor(actor)

        rvList.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rvList.adapter = adaptor

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


}
