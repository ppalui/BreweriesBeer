package com.base.project.data.local.base
import com.base.project.data.entity.GroupBeerListEntity
import io.reactivex.Observable

interface BreweriesCache {
	fun getGroupBeerList(): Observable<GroupBeerListEntity>
}