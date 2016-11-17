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

class NewGameActivity : AppCompatActivity() {

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

    private fun initData() = listOf(Avatar(AvatarName.BIRD), Avatar(AvatarName.CAT), Avatar(AvatarName.CHICKEN), Avatar(AvatarName.DOG), Avatar(AvatarName.DUCK), Avatar(AvatarName.FISH),
            Avatar(AvatarName.GOAT), Avatar(AvatarName.HIPPO), Avatar(AvatarName.HORSE), Avatar(AvatarName.LAMB), Avatar(AvatarName.LION), Avatar(AvatarName.MONKEY), Avatar(AvatarName.MOUSE),
            Avatar(AvatarName.OWL), Avatar(AvatarName.PIG), Avatar(AvatarName.REDPANDA), Avatar(AvatarName.TIGER), Avatar(AvatarName.WOLF))

}
