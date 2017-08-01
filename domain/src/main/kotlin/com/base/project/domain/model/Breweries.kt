package com.base.project.domain.model

data class Breweries (
	val id: String?,
	val name: String?,
	val nameShortDisplay: String?,
	val description: String?,
	val established: String?,
	val isOrganic: String?,
	val images: BreweriesImage?,
	val statusDisplay: String?,
	val createDate: String?,
	val updateDate: String?,
	val brandClassification: String?,
    val locations: List<Location>?
)