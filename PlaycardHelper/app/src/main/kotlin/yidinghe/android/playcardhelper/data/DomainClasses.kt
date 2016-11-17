package yidinghe.android.playcardhelper.data

import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_grid_avatar_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.utils.CommonLib
import java.util.*

/**
 * Created by yidinghe on 11/16/16.
 */

data class User(val userName: String, val rank: Int, val score: Double, val imageUrl: String)

data class Avatar(val avatarName: AvatarName, val male: Boolean, val imageIndex: Int = 0, val background: Int = Random().nextInt(3))

fun Avatar.loadBackgroundImage(imageView: ImageView){
    when(background){
        0 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_1).into(imageView)
        1 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_2).into(imageView)
        2 -> Picasso.with(CommonLib.getApp()).load(R.mipmap.avatar_background_3).into(imageView)
    }
}

fun Avatar.loadAvatarImage(imageView: ImageView){

    if (male){
        when(imageIndex){
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
    }else{
        when(imageIndex){
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

enum class AvatarName {
    TAO_LAOBAN, YANG_DAO, LIANG_GE, ZI_DAO, XUN_GE, JIE_GE, WEI_ZONG, WONG_DAO, LEI_ZONG, A_NUO, BAI_LU, QIANG_GE, HUANG, HE, TANG, SHEN_TONG
}