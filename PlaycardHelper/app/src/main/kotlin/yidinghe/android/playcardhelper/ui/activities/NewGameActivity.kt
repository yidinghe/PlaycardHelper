package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.Avatar
import yidinghe.android.playcardhelper.data.AvatarName
import yidinghe.android.playcardhelper.ui.adapters.AvatarGridAdapter
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

        snackBar("NewGame Started, Choose Players")

        val avatarRecyclerView: RecyclerView = find(R.id.avatar_recycler_view)
        avatarRecyclerView.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        avatarRecyclerView.adapter = AvatarGridAdapter(initData()) {
            toast(it.avatarName.name)
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
