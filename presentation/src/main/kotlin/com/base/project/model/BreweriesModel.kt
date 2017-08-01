package com.base.project.model

data class BreweriesModel (
	val id: String?,
	val name: String?,
	val nameShortDisplay: String?,
	val description: String?,
	val established: String?,
	val isOrganic: String?,
	val images: BreweriesImageModel?,
	val statusDisplay: String?,
	val createDate: String?,
	val brandClassification: String?,
    val locations: List<LocationModel>?
)