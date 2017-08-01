package com.base.project.domain.model

data class Beer (
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
	val breweries: List<Breweries>?
)