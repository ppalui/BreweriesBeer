package com.base.project.data.entity.mapper

import com.base.project.data.entity.*
import com.base.project.domain.model.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

open class BeersEntityDataMapper @Inject constructor() {
	open fun toGroupBeers(entity: GroupBeerListEntity?): GroupBeerList? {
		return entity?.let {
			GroupBeerList(
				currentPage = it.currentPage,
				numberOfPages = it.numberOfPages,
				beerList = toBeersList(it.beerList)
			)
		}
	}

	private fun toBeersList(entity: List<BeerEntity>?): List<Beer>? {
		return entity?.mapNotNull { toBeer(it) }
	}

	private fun toBeer(entity: BeerEntity?): Beer? {
		return entity?.let {
			Beer(
				id = it.id,
				name = it.name,
				nameDisplay = it.nameDisplay,
				description = it.description,
				abv = it.abv,
				availableId = it.availableId,
				styleId = it.styleId,
				isOrganic = it.isOrganic,
				statusDisplay = it.statusDisplay,
				createDate = it.createDate,
				updateDate = it.updateDate,
				breweries = toBreweriesList(it.breweries)
			)
		}
	}

	private fun toBreweriesList(entity: List<BreweriesEntity>?): List<Breweries>? {
		return entity?.mapNotNull { toBreweries(it) }
	}

	private fun toBreweries(entity: BreweriesEntity?): Breweries? {
		return entity?.let {
			Breweries(
				id = it.id,
				name = it.name,
				nameShortDisplay = it.nameShortDisplay,
				description = it.description,
				established = it.established,
				isOrganic = it.isOrganic,
				images = toBreweriesImage(it.images),
				statusDisplay = it.statusDisplay,
				createDate = it.createDate,
				updateDate = it.updateDate,
				brandClassification = it.brandClassification,
				locations = toLocationList(it.locations)
			)
		}
	}

	private fun toLocationList(entity: List<LocationEntity>?): List<Location>?{
		return entity?.mapNotNull { toLocationList(it) }
	}

	private fun toLocationList(entity: LocationEntity?): Location? {
		return entity?.let { Location(website = it.website) }
	}

	private fun toBreweriesImage(entity: BreweriesImageEntity?): BreweriesImage? {
		return entity?.let {
			BreweriesImage(
				icon = it.icon,
				medium = it.medium,
				large = it.large,
				squareMedium = it.squareMedium,
				squareLarge = it.squareLarge
			)
		}
	}
}