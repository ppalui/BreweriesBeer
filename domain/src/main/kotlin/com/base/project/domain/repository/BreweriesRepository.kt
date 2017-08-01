package com.base.project.domain.repository
import com.base.project.domain.model.GroupBeerList
import io.reactivex.Observable

interface BreweriesRepository {
	fun getGroupBeersList(page: Int, styleId: Int): Observable<GroupBeerList>
}