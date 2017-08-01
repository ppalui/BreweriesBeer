package com.base.project.data.repository.datasource.breweries

import com.base.project.data.local.base.BreweriesCache
import com.base.project.data.net.ApiConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BreweriesDataStoreFactory
@Inject constructor(private val breweriesCache: BreweriesCache, private val apiConnection: ApiConnection) {
	open fun createCloud(): BreweriesDataStore {
		val beersRestApi = apiConnection.createBreweriesRestApi()
		return CloudBreweriesDataStore(beersRestApi, breweriesCache)
	}
}