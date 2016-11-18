package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import com.google.gson.Gson
import org.jetbrains.anko.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.Avatar
import yidinghe.android.playcardhelper.data.AvatarName
import yidinghe.android.playcardhelper.data.DataMapper
import yidinghe.android.playcardhelper.data.GameData
import yidinghe.android.playcardhelper.ui.adapters.AvatarGridAdapter
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.snackBar
import java.util.*

class NewGameActivity : AppCompatActivity() {

    private val maleImageIndexHashSet = HashSet<Int>()
    private val femaleImageIndexHashSet = HashSet<Int>()

    private val MALE_IMAGE_INDEX_UPPER_BOUND = 13
    private val FEMALE_IMAGE_INDEX_UPPER_BOUND = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        snackBar("New Game Start, Please add Players")

        val avatarRecyclerView: RecyclerView = find(R.id.avatar_recycler_view)
        avatarRecyclerView.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)

        val avatars = initData()

        avatarRecyclerView.adapter = AvatarGridAdapter(avatars) {
            if (it.isChecked) {
                snackBar("Player ${it.avatarName.name} is added into the game")
            } else {
                snackBar("Player ${it.avatarName.name} is removed from the game")
            }

        }


        val nextButton: Button = find(R.id.new_game_next_button)
        nextButton.setOnClickListener {
            val users = DataMapper().convertFromAvatarToUser(avatars)

            if (users.size == 0) {
                snackBar("No Players added. Please add Players")
            } else if (users.size < 4) {
                snackBar(" Min 4 Players needed. Please add some Players")
            } else if (users.size > 8) {
                snackBar(" Max 8 Players Allowed. Please remove some Players")
            } else {
                val gameInfo = Gson().toJson(GameData(users))
                Log.d(javaClass.simpleName, gameInfo)
                alert("${users.size} Players are ${DataMapper().getAllUserName(users)}", "Please confirm users") {
                    yesButton {
                        CommonLib.putGameInfo(gameInfo)
                        startActivity<GameBoardActivity>()
                        finish()
                    }
                    noButton {}
                }.show()
            }

        }

    }

    private fun initData() = listOf(Avatar(AvatarName.TAO_LAOBAN, true, getRandomAvatarIndex(true)), Avatar(AvatarName.YANG_DAO, true, getRandomAvatarIndex(true)), Avatar(AvatarName.LIANG_GE, true, getRandomAvatarIndex(true)), Avatar(AvatarName.ZI_DAO, true, getRandomAvatarIndex(true)),
            Avatar(AvatarName.XUN_GE, true, getRandomAvatarIndex(true)), Avatar(AvatarName.JIE_GE, true, getRandomAvatarIndex(true)), Avatar(AvatarName.WEI_ZONG, false, getRandomAvatarIndex(false)), Avatar(AvatarName.WONG_DAO, false, getRandomAvatarIndex(false)),
            Avatar(AvatarName.LEI_ZONG, false, getRandomAvatarIndex(false)), Avatar(AvatarName.A_NUO, false, getRandomAvatarIndex(false)), Avatar(AvatarName.BAI_LU, false, getRandomAvatarIndex(false)), Avatar(AvatarName.QIANG_GE, true, getRandomAvatarIndex(true)),
            Avatar(AvatarName.HUANG, true, getRandomAvatarIndex(true)), Avatar(AvatarName.HE, true, getRandomAvatarIndex(true)), Avatar(AvatarName.TANG, false, getRandomAvatarIndex(false)), Avatar(AvatarName.SHEN_TONG, false, getRandomAvatarIndex(false)))

    private fun getRandomAvatarIndex(male: Boolean): Int {

        var index = 0

        if (male) {
            index = Random().nextInt(MALE_IMAGE_INDEX_UPPER_BOUND)
            while (maleImageIndexHashSet.contains(index)) {
                index = Random().nextInt(MALE_IMAGE_INDEX_UPPER_BOUND)
            }
            maleImageIndexHashSet.add(index)
            return index
        } else {
            index = Random().nextInt(FEMALE_IMAGE_INDEX_UPPER_BOUND)
            while (femaleImageIndexHashSet.contains(index)) {
                index = Random().nextInt(FEMALE_IMAGE_INDEX_UPPER_BOUND)
            }
            femaleImageIndexHashSet.add(index)
            return index
        }

    }

}
