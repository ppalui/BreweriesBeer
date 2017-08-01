package com.base.project.data.entity

data class BreweriesEntity (
	val id: String?,
	val name: String?,
	val nameShortDisplay: String?,
	val description: String?,
	val established: String?,
	val isOrganic: String?,
	val images: BreweriesImageEntity?,
	val statusDisplay: String?,
	val createDate: String?,
	val updateDate: String?,
	val brandClassification: String?,
    val locations: List<LocationEntity>?
)