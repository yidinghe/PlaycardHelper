package yidinghe.android.playcardhelper.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import yidinghe.android.playcardhelper.App

/**
 * Created by yidinghe on 11/16/16.
 */

class CommonLib {

    companion object {

        private val SHARED_PREFERENCE_KEY = "PLAY_CARD_HELPER_SP"
        private val KEY_GAME_INFO = "GAME_INFO"
        private var sAppInstance: App? = null

        fun getApp() = App.applicationInstance
        private fun getSp() = getApp().getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)

        fun putGameInfo(gameInfo: String) = getSp().edit().putString(KEY_GAME_INFO, gameInfo).apply()
        fun getGameInfo() = getSp().getString(KEY_GAME_INFO, "")
        fun isGameInfoExisted() = getSp().contains(KEY_GAME_INFO)

        fun clearSP() = getSp().edit().clear().apply()
    }

}

