package com.base.project.view

import com.base.project.model.PixabayImageModel
import com.navik.presentation.view.LoadDataView

interface HomeView : LoadDataView {
	fun showImage(imageSource: PixabayImageModel)
}