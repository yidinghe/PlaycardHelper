package yidinghe.android.playcardhelper.ui.activities

import android.graphics.drawable.NinePatchDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.h6ah4i.android.widget.advrecyclerview.decoration.ItemShadowDecorator
import org.jetbrains.anko.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.UserAction
import yidinghe.android.playcardhelper.ui.adapters.UserActionGridAdapter
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.snackBar


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userActionRecyclerView: RecyclerView = find(R.id.user_action_recycler_view)
        userActionRecyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        userActionRecyclerView.adapter = UserActionGridAdapter(initData()) {
            when (it) {
                UserAction.NEW_GAME -> startNewGame()
                UserAction.CONTINUE -> startContinueGame()
                UserAction.RANK -> startRank()
                UserAction.HELP -> startHelp()
                UserAction.ABOUT -> startAbout()
            }
        }
        // userActionRecyclerView.addItemDecoration(ItemShadowDecorator(getDrawable(R.drawable.material_shadow_z1) as NinePatchDrawable))


    }

    private fun initData(): List<UserAction> =
            listOf(UserAction.NEW_GAME, UserAction.CONTINUE, UserAction.RANK, UserAction.HELP, UserAction.ABOUT)

    private fun startNewGame() {
        if (CommonLib.isGameInfoExisted())
            alert("Reset and start a new game?", "New Game") {
                yesButton {
                    CommonLib.clearSP()
                    startActivity<NewGameActivity>()
                }
                noButton {}
            }.show()
        else
            startActivity<NewGameActivity>()
    }

    private fun startContinueGame() {
        if (CommonLib.isGameInfoExisted())
            startActivity<GameBoardActivity>()
        else
            snackBar("No Game Data, please start a New Game.")

    }


    private fun startAbout() {
//        startActivity<AboutActivity>()
//        snackBar("Not implemented yet")
        alert("Version = 0.1", "About") {
            okButton { }
        }.show()
    }

    private fun startHelp() {
//        startActivity<HelpActivity>()
        alert("Not implemented yet", "Help") {
            okButton { }
        }.show()
    }

    private fun startRank() {
        if (CommonLib.isGameInfoExisted())
            startActivity<RankActivity>()
        else
            snackBar("No Game Data, please start a New Game.")
    }


}



