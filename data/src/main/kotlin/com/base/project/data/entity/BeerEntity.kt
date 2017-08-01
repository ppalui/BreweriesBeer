package com.base.project.data.entity

data class BeerEntity (
	val id: String?,
	val name: String?,
	val nameDisplay: String?,
	val description: String?,
	val abv: String?,
	val availableId: Int?,
	val styleId: Int?,
	val isOrganic: String?,
	val statusDisplay: String?,
	val createDate: String?,
	val updateDate: String?,
	val breweries: List<BreweriesEntity>?
)