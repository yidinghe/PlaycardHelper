package yidinghe.android.playcardhelper.data

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_grid_avatar_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.utils.CommonLib
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
        Picasso.with(CommonLib.getApp()).load(R.mipmap.gou).into(imageView)
    } else {
        Picasso.with(CommonLib.getApp()).load(R.mipmap.gou2).into(imageView)
    }
}

fun User.loadRankImage(imageView: ImageView, rank: Int) {
    when (rank) {
        0 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_1).into(imageView)
        1 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_2).into(imageView)
        2 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_3).into(imageView)
        3 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_4).into(imageView)
        4 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_5).into(imageView)
        5 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_6).into(imageView)
        6 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_7).into(imageView)
        7 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.number_8).into(imageView)
    }
}

data class Avatar(val avatarName: AvatarName, val male: Boolean, val imageIndex: Int = 0, val background: Int = Random().nextInt(3), var isChecked: Boolean = false)

fun Avatar.loadBackgroundImage(imageView: ImageView) {
    when (background) {
        0 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_1).into(imageView)
        1 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_2).into(imageView)
        2 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_3).into(imageView)
    }
}

fun Avatar.loadAvatarImage(imageView: ImageView) {

    if (male) {
        when (imageIndex) {
            0 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_00).into(imageView)
            1 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_01).into(imageView)
            2 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_02).into(imageView)
            3 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_03).into(imageView)
            4 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_04).into(imageView)
            5 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_05).into(imageView)
            6 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_06).into(imageView)
            7 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_07).into(imageView)
            8 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_08).into(imageView)
            9 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_09).into(imageView)
            10 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_10).into(imageView)
            11 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_11).into(imageView)
            12 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.male_12).into(imageView)
        }
    } else {
        when (imageIndex) {
            0 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_00).into(imageView)
            1 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_01).into(imageView)
            2 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_02).into(imageView)
            3 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_03).into(imageView)
            4 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_04).into(imageView)
            5 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_05).into(imageView)
            6 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_06).into(imageView)
            7 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_07).into(imageView)
            8 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_08).into(imageView)
            9 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_09).into(imageView)
            10 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.female_010).into(imageView)
        }
    }

}

enum class UserAction {
    NEW_GAME, CONTINUE, RANK, HELP, ABOUT
}


fun UserAction.loadBackgroundImage(imageView: ImageView) {
    when (this) {
        UserAction.ABOUT -> Picasso.with(CommonLib.getApp()).load(R.mipmap.fengqiu).into(imageView)
        UserAction.NEW_GAME -> Picasso.with(CommonLib.getApp()).load(R.mipmap.huoqiu).into(imageView)
        UserAction.CONTINUE -> Picasso.with(CommonLib.getApp()).load(R.mipmap.shuiqiu).into(imageView)
        UserAction.RANK -> Picasso.with(CommonLib.getApp()).load(R.mipmap.leiqiu).into(imageView)
        UserAction.HELP -> Picasso.with(CommonLib.getApp()).load(R.mipmap.tuqiu).into(imageView)
    }
}

enum class AvatarName {
    TAO_LAOBAN, YANG_DAO, LIANG_GE, ZI_DAO, XUN_GE, JIE_GE, WEI_ZONG, WONG_DAO, LEI_ZONG, A_NUO, BAI_LU, QIANG_GE, HUANG, HE, TANG, SHEN_TONG
}