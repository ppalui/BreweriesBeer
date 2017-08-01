package com.base.project.ui.adapter.base

import com.airbnb.epoxy.EpoxyAdapter
import com.airbnb.epoxy.EpoxyModel
import com.base.project.model.epoxy.EmptyModel_
import com.base.project.model.epoxy.ErrorModel_
import com.base.project.model.epoxy.LoadingModel_

abstract class BaseEpoxyAdapter : EpoxyAdapter() {
	open protected val errorModel: EpoxyModel<*> = ErrorModel_()
	open protected val emptyModel: EpoxyModel<*> = EmptyModel_()
	open protected val loadingModel: EpoxyModel<*> = LoadingModel_()

	protected abstract fun clearItemList()

	open fun loading() {
		clearItemList()
		addModel(loadingModel)
	}

	open fun error() {
		clearItemList()
		addModel(errorModel)
	}

	open fun empty() {
		clearItemList()
		addModel(emptyModel)
	}
}