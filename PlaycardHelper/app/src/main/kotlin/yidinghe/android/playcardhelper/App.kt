package yidinghe.android.playcardhelper

import android.app.Application
import android.util.Log
import yidinghe.android.playcardhelper.utils.CommonLib

/**
 * Created by yiding on 11/14/2016.
 */

class App : Application() {

    companion object {
        lateinit var applicationInstance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        applicationInstance = this
    }
}