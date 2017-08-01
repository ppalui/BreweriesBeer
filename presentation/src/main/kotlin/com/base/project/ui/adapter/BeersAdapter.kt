package com.base.project.ui.adapter

import com.base.project.extensions.BeerItemClickListener
import com.base.project.model.BreweriesModel
import com.base.project.model.epoxy.BeersItemModel_
import com.base.project.ui.adapter.base.BaseEpoxyAdapter

class BeersAdapter : BaseEpoxyAdapter() {

	var beerItemClickListener: BeerItemClickListener? = null

	fun setBeersList(itemList: List<BreweriesModel>?) {
		//clearItemList()
		appendBeerList(itemList)
	}

	fun appendBeerList(itemList: List<BreweriesModel>?) {
		itemList?.mapNotNull {
			addModel(
				BeersItemModel_()
					.model(it)
					.beerItemClickListener(beerItemClickListener)
			)
		}
	}

	override fun clearItemList() {
		removeAllModels()
	}
}