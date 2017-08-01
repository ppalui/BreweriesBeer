package com.base.project.view

import com.base.project.model.GroupBeerListModel
import com.navik.presentation.view.LoadDataView

interface BeersView: LoadDataView {
	fun  displayBeersList(groupBeersList: GroupBeerListModel)
	fun  appendBeersList(groupBeersList: GroupBeerListModel)
}