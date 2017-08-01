package com.base.project.domain.model

data class GroupBeerList (
	val currentPage: Int,
	val numberOfPages: Int,
	val beerList: List<Beer>? = null
)