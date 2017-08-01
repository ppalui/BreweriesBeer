package com.base.project.mapper

import com.base.project.domain.model.*
import com.base.project.internal.di.PerFragment
import com.base.project.model.*
import javax.inject.Inject

@PerFragment
open class BeersModelDataMapper @Inject constructor() {
	open fun toGroupBeersModel(model: GroupBeerList?): GroupBeerListModel? {
		return model?.let {
			GroupBeerListModel(
				currentPage = it.currentPage,
				beerList = toBeersList(it.beerList)
			)
		}
	}

	private fun toBeersList(model: List<Beer>?): List<BeerModel>? {
		return model?.mapNotNull { toBeer(it) }
	}

	private fun toBeer(model: Beer): BeerModel? {
		return model.let {
			BeerModel(
				id = it.id,
				nameDisplay = it.nameDisplay,
				description = it.description,
				abv = it.abv,
				styleId = it.styleId,
				isOrganic = it.isOrganic,
				statusDisplay = it.statusDisplay,
				createDate = it.createDate,
				breweries = toBreweriesModelList(it.breweries)
			)
		}
	}

	private fun toBreweriesModelList(model: List<Breweries>?): List<BreweriesModel>? {
		return model?.mapNotNull { toBreweries(it) }
	}

	private fun toBreweries(model: Breweries?): BreweriesModel? {
		return model?.let {
			BreweriesModel(
				id = it.id,
				name = it.name,
				nameShortDisplay = it.nameShortDisplay,
				description = it.description,
				established = it.established,
				isOrganic = it.isOrganic,
				images = toBreweriesImage(it.images),
				statusDisplay = it.statusDisplay,
				createDate = it.createDate,
				brandClassification = it.brandClassification,
				locations = toLocationModel(it.locations)
			)
		}
	}

	private fun toLocationModel(model: List<Location>?): List<LocationModel>? {
		return model?.mapNotNull { toLocationModel(it) }
	}

	private fun toLocationModel(model: Location?): LocationModel? {
		return model?.let { LocationModel(website = it.website) }
	}

	private fun toBreweriesImage(model: BreweriesImage?): BreweriesImageModel? {
		return model?.let {
			BreweriesImageModel(
				icon = it.icon,
				large = it.large,
				squareLarge = it.squareLarge
			)
		}
	}
}