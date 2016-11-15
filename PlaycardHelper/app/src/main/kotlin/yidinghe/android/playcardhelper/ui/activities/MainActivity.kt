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
        userActionRecyclerView.addItemDecoration(ItemShadowDecorator(getDrawable(R.drawable.material_shadow_z1) as NinePatchDrawable))


    }

    private fun initData(): List<UserAction> =
            listOf(UserAction.NEW_GAME, UserAction.CONTINUE, UserAction.RANK, UserAction.HELP, UserAction.ABOUT)

    private fun startNewGame() = alert("New Game", "Reset and start a new game?") {
        yesButton {
            //TODO clear the SP
            startActivity<NewGameActivity>()
        }
        noButton {}
    }.show()

    private fun startContinueGame() = alert("Continue Game", "Continue") {
        yesButton {
            //TODO check the SP for game, if not just shakeBar
            startActivity<GameActivity>()
        }
        noButton {}
    }.show()

    private fun startAbout() = startActivity<AboutActivity>()
    private fun startHelp() = startActivity<HelpActivity>()
    private fun startRank() = alert("Rank", "Rank") {
        yesButton {
            //TODO check the SP for game, if not just shakeBar
            startActivity<RankActivity>()
        }
        noButton {}
    }.show()

}



