package com.base.project.model

data class GroupBeerListModel(
	val currentPage: Int,
	val beerList: List<BeerModel>? = null
)