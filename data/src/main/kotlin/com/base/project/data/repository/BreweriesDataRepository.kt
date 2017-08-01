package com.base.project.data.repository

import com.base.project.data.entity.mapper.BeersEntityDataMapper
import com.base.project.data.repository.datasource.breweries.BreweriesDataStoreFactory
import com.base.project.domain.model.GroupBeerList
import com.base.project.domain.repository.BreweriesRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreweriesDataRepository
@Inject constructor(private val breweriesDataStoreFactory: BreweriesDataStoreFactory,
                    private val breweriesDataMapper: BeersEntityDataMapper): BreweriesRepository {
	override fun getGroupBeersList(page: Int, styleId: Int): Observable<GroupBeerList> {
		return breweriesDataStoreFactory.createCloud().listBeer(styleId, page).map { breweriesDataMapper.toGroupBeers(it) }
	}
}