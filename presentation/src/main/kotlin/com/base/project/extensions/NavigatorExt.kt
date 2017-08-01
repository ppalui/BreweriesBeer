package com.base.project.extensions

import android.support.v4.app.Fragment
import com.base.project.ui.activity.BeersActivity

fun Fragment.navigateToBeerList() {
	val intentToLaunch = BeersActivity.getCallingIntent(context)
	this.startActivity(intentToLaunch)
}