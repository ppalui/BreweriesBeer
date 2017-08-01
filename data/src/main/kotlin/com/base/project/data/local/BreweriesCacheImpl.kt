package com.base.project.data.local

import android.content.Context
import com.base.project.data.entity.GroupBeerListEntity
import com.base.project.data.local.base.BreweriesCache
import com.base.project.data.local.base.DbWrapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BreweriesCacheImpl @Inject constructor(context: Context): BreweriesCache {

	private val db by lazy { DbWrapper(context, "beers") }

	override fun getGroupBeerList(): Observable<GroupBeerListEntity> {
		throw UnsupportedOperationException("not implemented")
	}
}