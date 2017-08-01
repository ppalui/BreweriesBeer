package com.base.project.domain.interactor

import com.base.project.domain.model.GroupBeerList
import com.base.project.domain.params.GetGroupBeerParams
import com.base.project.domain.repository.BreweriesRepository
import com.navik.domain.executor.PostExecutionThread
import com.navik.domain.interactor.UseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

open class GetGroupBeers
@Inject constructor(private val beerRepository: BreweriesRepository,
                    scheduler: Scheduler,
                    postExecutionThread: PostExecutionThread) : UseCase<GroupBeerList, GetGroupBeerParams>(scheduler, postExecutionThread) {
	override fun buildUseCaseObservable(params: GetGroupBeerParams?): Observable<GroupBeerList> {
		if (params == null) {
			throw IllegalArgumentException("buildUseCaseObservable(params) not called, or called with null argument.")
		}

		return beerRepository.getGroupBeersList(page = params.page, styleId = params.styleId)
	}
}