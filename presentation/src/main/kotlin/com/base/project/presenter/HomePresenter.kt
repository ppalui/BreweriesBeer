package com.base.project.presenter

import com.base.project.domain.interactor.GetPixabayImageByKeyword
import com.base.project.domain.model.PixabayImage
import com.base.project.domain.params.ListPixabayImageParams
import com.base.project.exception.ErrorMessageFactory
import com.base.project.internal.di.PerFragment
import com.base.project.mapper.PixabayImageModelDataMapper
import com.base.project.view.HomeView
import com.navik.data.exception.retrofit.DataErrorBundle
import com.navik.domain.exception.ErrorBundle
import com.navik.domain.interactor.DefaultObserver
import com.navik.presentation.presenter.Presenter
import javax.inject.Inject

@PerFragment
class HomePresenter
@Inject constructor(private val mGetPixabayImageByKeywordUseCase: GetPixabayImageByKeyword,
					private val mDataMapper: PixabayImageModelDataMapper) : Presenter<HomeView>() {

	companion object {
		private val PER_PAGE_LIMIT = 21
	}

	override fun destroy() {
		super.destroy()
		mGetPixabayImageByKeywordUseCase.dispose()
	}

	fun loadImage(keyword: String?, page: Int = 1, limit: Int = PER_PAGE_LIMIT) {
		view?.showLoading()
		val loadImageParams = ListPixabayImageParams(keyword, page, limit)
		mGetPixabayImageByKeywordUseCase.execute(GetPixabayImageSubscriber(), loadImageParams)
	}

	fun showErrorMessage(errorBundle: ErrorBundle) {
		val errorMessage = ErrorMessageFactory.create(view?.context(), errorBundle.exception())
		view?.showError(errorMessage)
	}

	private inner class GetPixabayImageSubscriber : DefaultObserver<PixabayImage>() {
		override fun onComplete() {
			view?.hideLoading()
		}

		override fun onError(e: Throwable) {
			view?.hideLoading()
			val errorBundle = DataErrorBundle(e as Exception)
			showErrorMessage(errorBundle)
		}

		override fun onNext(t: PixabayImage) {
			val imageSource = mDataMapper.toPixabayImageModel(t)
			imageSource?.let {
				view?.showImage(it)
			}
		}

	}
}