package com.base.project.data.net

import com.base.project.data.net.api.BreweriesRestApi
import com.base.project.data.net.api.PixabayRestApi

interface ApiConnection {
	fun createPixabayRestApi(): PixabayRestApi

	fun createBreweriesRestApi(): BreweriesRestApi
}