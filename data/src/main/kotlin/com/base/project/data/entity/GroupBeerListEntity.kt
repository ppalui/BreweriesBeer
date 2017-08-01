package com.base.project.data.entity

import com.google.gson.annotations.SerializedName

data class GroupBeerListEntity(
	val currentPage: Int,
	val numberOfPages: Int,
	@SerializedName("data") val beerList: List<BeerEntity>? = null
)