package com.base.project.presenter

import com.base.project.domain.interactor.GetGroupBeers
import com.base.project.domain.model.GroupBeerList
import com.base.project.domain.params.GetGroupBeerParams
import com.base.project.mapper.BeersModelDataMapper
import com.base.project.view.BeersView
import com.navik.domain.interactor.DefaultObserver
import com.navik.presentation.presenter.Presenter
import timber.log.Timber
import javax.inject.Inject

class BeersPresenter
@Inject constructor(private val mGetGroupBeers: GetGroupBeers,
                    private val mBeersModelDataMapper: BeersModelDataMapper) : Presenter<BeersView>() {

	private var mStyleId = 30

	override fun destroy() {
		super.destroy()
		mGetGroupBeers.dispose()
	}

	fun loadGroupBeersList(page: Int = 1, styleId: Int = mStyleId) {
		val params = GetGroupBeerParams(page, styleId)
		mGetGroupBeers.execute(GetGroupBeersObserver(), params)
	}

	fun loadMoreGroupBeersList(page: Int) {
		val params = GetGroupBeerParams(page, mStyleId)
		mGetGroupBeers.execute(GetGroupBeersMoreObserver(), params)
	}

	private inner class GetGroupBeersObserver: DefaultObserver<GroupBeerList>() {
		override fun onError(e: Throwable) {
			Timber.e("ERROR : "+e)
		}

		override fun onNext(t: GroupBeerList) {
			val model = mBeersModelDataMapper.toGroupBeersModel(t)
			model?.let {
				mStyleId = it.beerList?.last()?.styleId?: 30
				view?.displayBeersList(it)
			}
		}
	}

	private inner class GetGroupBeersMoreObserver: DefaultObserver<GroupBeerList>() {
		override fun onError(e: Throwable) {
			Timber.e("ERROR : "+e)
		}

		override fun onNext(t: GroupBeerList) {
			val model = mBeersModelDataMapper.toGroupBeersModel(t)
			model?.let {
				mStyleId = it.beerList?.last()?.styleId?: 30
				view?.appendBeersList(it)
			}
		}
	}

}