package yidinghe.android.playcardhelper.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import yidinghe.android.playcardhelper.App
import yidinghe.android.playcardhelper.data.GameData

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
        fun getGameInfo() = Gson().fromJson(getSp().getString(KEY_GAME_INFO, ""), GameData::class.java)
        fun isGameInfoExisted() = getSp().contains(KEY_GAME_INFO)

        fun clearSP() = getSp().edit().clear().apply()
    }

}

