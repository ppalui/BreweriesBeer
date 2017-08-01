package com.base.project.model

data class BeerModel(
	val id: String?,
	val nameDisplay: String?,
	val description: String?,
	val abv: String?,
	val styleId: Int?,
	val isOrganic: String?,
	val statusDisplay: String?,
	val createDate: String?,
	val breweries: List<BreweriesModel>?
)