package com.base.project.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.base.project.R
import com.base.project.ui.fragment.BeersFragment

class BeersActivity: BaseActivity() {
	override fun getContentViewId(): Int = R.layout.activity_layout

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTitle(R.string.beers_title)
		initializeActivity(savedInstanceState)
	}

	private fun initializeActivity(savedInstanceState: Bundle?) {
		if (savedInstanceState == null) {
			addFragment(R.id.fragmentContainer, BeersFragment())
		}
	}

	companion object {
		fun getCallingIntent(context: Context): Intent {
			return Intent(context, BeersActivity::class.java)
		}
	}
}