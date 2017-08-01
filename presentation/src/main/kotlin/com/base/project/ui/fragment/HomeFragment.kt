package com.base.project.ui.fragment

import android.os.Bundle
import android.view.View
import com.base.project.R
import com.base.project.extensions.navigateToBeerList
import com.base.project.ui.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*




class HomeFragment : BaseFragment() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		activityComponent().getHomeComponent().inject(this)
	}

	override fun getContentViewId(): Int = R.layout.fragment_home

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		onBindData()
		onBindEvent()
	}

	private fun onBindData() {
		val imageSlideList = listOf(R.drawable.bg_beer_selection1, R.drawable.bg_beer_selection2,
			R.drawable.bg_beer_selection3, R.drawable.bg_beer_selection4, R.drawable.bg_beer_selection5 )

		carouselView.pageCount = imageSlideList.size
		carouselView.setImageListener { position, imageView -> imageView.setImageResource(imageSlideList[position]) }
	}

	private fun onBindEvent() {
		layoutSeeMoreBeer.setOnClickListener {
			navigateToBeerList()
		}
	}
}