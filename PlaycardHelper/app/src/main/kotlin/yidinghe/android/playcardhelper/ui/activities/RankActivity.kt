package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.ui.adapters.UserRankListAdapter
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.snackBar

class RankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }

    private fun initViews() {

        val rankMessageText: TextView = find(R.id.rank_message_text)
        val gameInfo = CommonLib.getGameInfo()
        rankMessageText.text = "Round  " + gameInfo.round

        val gameBoardRecyclerView: RecyclerView = find(R.id.rank_recycler_view)
        gameBoardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        gameBoardRecyclerView.adapter = UserRankListAdapter(gameInfo.users.sortedBy { it.score })
    }
}
