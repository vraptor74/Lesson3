package com.example.nikita_khoryakov_shop.di

import android.content.Context
import com.example.nikita_khoryakov_shop.di.modules.MainApiModule
import com.example.nikita_khoryakov_shop.di.modules.PreferencesModule
import com.example.nikita_khoryakov_shop.ui.DetailedActivity
import com.example.nikita_khoryakov_shop.ui.cart.catalog.CatalogActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        PreferencesModule::class,
        MainApiModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: CatalogActivity)
    fun inject(activity: DetailedActivity)
}