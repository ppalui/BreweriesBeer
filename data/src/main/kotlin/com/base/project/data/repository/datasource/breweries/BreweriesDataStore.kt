package com.base.project.data.repository.datasource.breweries
import com.base.project.data.entity.GroupBeerListEntity
import io.reactivex.Observable

interface BreweriesDataStore {
	fun listBeer(styleId: Int, page: Int): Observable<GroupBeerListEntity>
}