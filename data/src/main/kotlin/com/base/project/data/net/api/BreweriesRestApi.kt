package com.base.project.data.net.api

import com.base.project.data.BuildConfig
import com.base.project.data.entity.GroupBeerListEntity
import com.base.project.data.net.Url
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesRestApi {
	@GET(Url.baseBeerVersion)
	fun listBeers(@Query("key") key: String = BuildConfig.BREWERIES_API_KEY,
	              @Query("styleId") styleId: Int,
	              @Query("p") page: Int,
	              @Query("withBreweries") withBreweries: String): Observable<GroupBeerListEntity>
}