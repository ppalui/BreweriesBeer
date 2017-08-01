package com.base.project.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.base.project.R
import com.base.project.model.GroupBeerListModel
import com.base.project.presenter.BeersPresenter
import com.base.project.ui.adapter.BeersAdapter
import com.base.project.ui.fragment.base.BaseFragment
import com.base.project.view.BeersView
import com.navik.multiplestate.EndlessRecyclerOnScrollListener
import kotlinx.android.synthetic.main.fragment_beers.*
import timber.log.Timber
import javax.inject.Inject


class BeersFragment : BaseFragment(), BeersView {

	@Inject internal lateinit var mPresenter: BeersPresenter
	private lateinit var mAdapter: BeersAdapter
	private val mLayoutManager = LinearLayoutManager(context)

	override fun getContentViewId(): Int = R.layout.fragment_beers

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		activityComponent().getBeersComponent().inject(this)
	}

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		mPresenter.setView(this)
		initRecyclerView()
		mPresenter.loadGroupBeersList()
	}

	override fun onDestroy() {
		super.onDestroy()
		mPresenter.destroy()
	}

	override fun context(): Context = context.applicationContext

	override fun hideLoading() {
		Timber.e("Hide Loading")
	}

	override fun showLoading() {
		mAdapter.loading()
	}

	override fun showError(message: String) {
		mAdapter.error()
	}

	override fun displayBeersList(groupBeersList: GroupBeerListModel) {
		groupBeersList.beerList?.mapNotNull {
			Timber.e("Show Beer List")
			mAdapter.setBeersList(it.breweries)
		}
	}

	override fun appendBeersList(groupBeersList: GroupBeerListModel) {
		groupBeersList.beerList?.mapNotNull {
			mAdapter.appendBeerList(it.breweries)
		}
	}

	private fun initRecyclerView() {
		mAdapter = BeersAdapter()

		recyclerViewBeersList.addOnScrollListener(mBeersListScrollListener)
		recyclerViewBeersList.layoutManager = mLayoutManager
		recyclerViewBeersList.adapter = mAdapter
		recyclerViewBeersList.setHasFixedSize(true)
	}

	private val mBeersListScrollListener = object : EndlessRecyclerOnScrollListener(mLayoutManager) {
		override fun onLoadMore(page: Int) {
			mPresenter.loadMoreGroupBeersList(page)
		}
	}
}