package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.ui.adapters.UserRankListAdapter
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.snackBar

class GameBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)

        val calculateButton: Button = find(R.id.calculate_button)

        calculateButton.setOnClickListener {
            startActivity<CalculatorActivity>()
        }

        snackBar("Welcome and Enjoy your game")
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }

    private fun initViews() {

        val titleTextView: TextView = find(R.id.game_board_round)
        val gameInfo = CommonLib.getGameInfo()
        titleTextView.text = "Round  " + gameInfo.round

        val gameBoardRecyclerView: RecyclerView = find(R.id.game_board_recycler_view)
        gameBoardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        gameBoardRecyclerView.adapter = UserRankListAdapter(gameInfo.users.sortedBy { it.score })
    }
}
