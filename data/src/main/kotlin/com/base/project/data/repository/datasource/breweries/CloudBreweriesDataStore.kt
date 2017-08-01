package com.base.project.data.repository.datasource.breweries

import com.base.project.data.entity.GroupBeerListEntity
import com.base.project.data.local.base.BreweriesCache
import com.base.project.data.net.api.BreweriesRestApi
import io.reactivex.Observable

class CloudBreweriesDataStore(private val breweriesRestApi: BreweriesRestApi,
                              private val breweriesCache: BreweriesCache): BreweriesDataStore {
	override fun listBeer(styleId: Int, page: Int): Observable<GroupBeerListEntity> {
		return breweriesRestApi.listBeers(styleId = styleId, page = page, withBreweries = "Y")
	}
}