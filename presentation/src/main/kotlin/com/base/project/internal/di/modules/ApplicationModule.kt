package com.base.project.internal.di.modules

import android.content.Context
import com.base.project.AndroidApplication
import com.base.project.UIThread
import com.base.project.data.local.BreweriesCacheImpl
import com.base.project.data.local.PixabayCacheImpl
import com.base.project.data.local.PreferenceHelperImpl
import com.base.project.data.local.base.BreweriesCache
import com.base.project.data.local.base.PixabayCache
import com.base.project.data.local.base.PreferenceHelper
import com.base.project.data.net.ApiConnection
import com.base.project.data.net.api.base.ApiConnectionImpl
import com.base.project.data.repository.BreweriesDataRepository
import com.base.project.data.repository.PixabayDataRepository
import com.base.project.domain.repository.BreweriesRepository
import com.base.project.domain.repository.PixabayRepository
import com.navik.domain.executor.PostExecutionThread
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule(private val application: AndroidApplication) {

	@Provides @Singleton internal fun provideApplicationContext(): Context {
		return this.application
	}

	@Provides @Singleton internal fun provideSchedulersIO(): Scheduler {
		return Schedulers.io()
	}

	@Provides @Singleton internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
		return uiThread
	}

	@Provides @Singleton internal fun provideApiConnection(apiConnection: ApiConnectionImpl): ApiConnection {
		return apiConnection
	}

	@Provides @Singleton internal fun providePixabayCache(pixabayCache: PixabayCacheImpl): PixabayCache {
		return pixabayCache
	}

	@Provides @Singleton internal fun provideBreweriesCache(breweriesCache: BreweriesCacheImpl): BreweriesCache {
		return breweriesCache
	}

	@Provides @Singleton internal fun providePreferenceHelper(preferenceHelper: PreferenceHelperImpl): PreferenceHelper {
		return preferenceHelper
	}

	@Provides @Singleton internal fun providePixabayRepository(pixabayDataRepository: PixabayDataRepository): PixabayRepository {
		return pixabayDataRepository
	}

	@Provides @Singleton internal fun provideBreweriesRepository(breweriesDataRepository: BreweriesDataRepository): BreweriesRepository {
		return breweriesDataRepository
	}
}