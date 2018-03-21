package yidinghe.android.playcardhelper.data

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_grid_avatar_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.loadRes
import java.util.*

/**
 * Created by yidinghe on 11/16/16.
 */

data class GameData(val users: List<User>, var round: Int = 1)

data class User(val avatar: Avatar, var totalScore: Double = 0.0, var score: Double = 0.0, var isBankerSideForThisRound: Boolean = false)

data class DragUser(val id: Int, val user: User)

fun User.loadCheckMark(imageView: ImageView) {
    imageView.visibility = View.VISIBLE
    if (isBankerSideForThisRound) {
        imageView.loadRes(R.mipmap.gou)
    } else {
        imageView.loadRes(R.mipmap.gou2)
    }
}

fun User.loadRankImage(imageView: ImageView, rank: Int) {
    when (rank) {
        0 -> imageView.loadRes(R.mipmap.number_1)
        1 -> imageView.loadRes(R.mipmap.number_2)
        2 -> imageView.loadRes(R.mipmap.number_3)
        3 -> imageView.loadRes(R.mipmap.number_4)
        4 -> imageView.loadRes(R.mipmap.number_5)
        5 -> imageView.loadRes(R.mipmap.number_6)
        6 -> imageView.loadRes(R.mipmap.number_7)
        7 -> imageView.loadRes(R.mipmap.number_8)
    }
}

data class Avatar(val avatarName: AvatarName, val male: Boolean, val imageIndex: Int = 0, val background: Int = Random().nextInt(3), var isChecked: Boolean = false)

fun Avatar.loadBackgroundImage(imageView: ImageView) {
    when (background) {
        0 -> imageView.loadRes(R.mipmap.avatar_background_1)
        1 -> imageView.loadRes(R.mipmap.avatar_background_2)
        2 -> imageView.loadRes(R.mipmap.avatar_background_3)
    }
}

fun Avatar.loadAvatarImage(imageView: ImageView) {

    if (male) {
        when (imageIndex) {
            0 -> imageView.loadRes(R.mipmap.male_00)
            1 -> imageView.loadRes(R.mipmap.male_01)
            2 -> imageView.loadRes(R.mipmap.male_02)
            3 -> imageView.loadRes(R.mipmap.male_03)
            4 -> imageView.loadRes(R.mipmap.male_04)
            5 -> imageView.loadRes(R.mipmap.male_05)
            6 -> imageView.loadRes(R.mipmap.male_06)
            7 -> imageView.loadRes(R.mipmap.male_07)
            8 -> imageView.loadRes(R.mipmap.male_08)
            9 -> imageView.loadRes(R.mipmap.male_09)
            10 -> imageView.loadRes(R.mipmap.male_10)
            11 -> imageView.loadRes(R.mipmap.male_11)
            12 -> imageView.loadRes(R.mipmap.male_12)
        }
    } else {
        when (imageIndex) {
            0 -> imageView.loadRes(R.mipmap.female_00)
            1 -> imageView.loadRes(R.mipmap.female_01)
            2 -> imageView.loadRes(R.mipmap.female_02)
            3 -> imageView.loadRes(R.mipmap.female_03)
            4 -> imageView.loadRes(R.mipmap.female_04)
            5 -> imageView.loadRes(R.mipmap.female_05)
            6 -> imageView.loadRes(R.mipmap.female_06)
            7 -> imageView.loadRes(R.mipmap.female_07)
            8 -> imageView.loadRes(R.mipmap.female_08)
            9 -> imageView.loadRes(R.mipmap.female_09)
        }
    }

}

enum class UserAction {
    NEW_GAME, CONTINUE, RANK, HELP, ABOUT
}


fun UserAction.loadBackgroundImage(imageView: ImageView) {
    when (this) {
        UserAction.ABOUT -> imageView.loadRes(R.mipmap.fengqiu)
        UserAction.NEW_GAME -> imageView.loadRes(R.mipmap.huoqiu)
        UserAction.CONTINUE -> imageView.loadRes(R.mipmap.shuiqiu)
        UserAction.RANK -> imageView.loadRes(R.mipmap.leiqiu)
        UserAction.HELP -> imageView.loadRes(R.mipmap.tuqiu)
    }
}

enum class AvatarName {
    TAO_LAOBAN, YANG_DAO, A_NUO, LIANG_GE, LEI_ZONG, ZI_DAO, WONG_DAO, JIE_GE, WEI_ZONG, BAI_LU, QIANG_GE, HE, TANG, XUN_GE, SHEN_TONG, HUANG
}