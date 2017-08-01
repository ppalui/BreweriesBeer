package com.base.project.internal.di.components.subcomponents

import com.base.project.internal.di.PerFragment
import com.base.project.ui.fragment.BeersFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = arrayOf())
interface BeersComponent {
	fun inject(beersFragment: BeersFragment)
}