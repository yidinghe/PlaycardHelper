package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import com.google.gson.Gson
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager
import com.h6ah4i.android.widget.advrecyclerview.utils.WrappedAdapterUtils
import org.jetbrains.anko.alert
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.DragUser
import yidinghe.android.playcardhelper.data.GameData
import yidinghe.android.playcardhelper.ui.adapters.DragUserRankListAdapter
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.snackBar

class CalculatorActivity : AppCompatActivity() {

    private lateinit var gameInfo: GameData
    private lateinit var dragUserRankAdapter: DragUserRankListAdapter
    private var scoreBankerSide = 0.0
    private var scoreNotBankerSide = 0.0
    private var scoreBankerSidePerUser = 0.0
    private var scoreNotBankerSidePerUser = 0.0
    private var namesBankerSide = StringBuilder()
    private var namesNotBankerSide = StringBuilder()
    private var round: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initViews()
    }

    fun initViews() {

        val calculatorRecyclerView: RecyclerView = find(R.id.calculate_recycler_view)

        val dragManager = RecyclerViewDragDropManager()

        dragManager.setInitiateOnMove(false)
        dragManager.setInitiateOnLongPress(true)

        calculatorRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        dragUserRankAdapter = DragUserRankListAdapter(getNewAdapterItems())

        calculatorRecyclerView.adapter = dragManager.createWrappedAdapter(dragUserRankAdapter)
        dragManager.attachRecyclerView(calculatorRecyclerView)

        val resetButton: Button = find(R.id.calculate_reset_button)

        resetButton.setOnClickListener {
            dragUserRankAdapter.changeItems(getNewAdapterItems())
            calculatorRecyclerView.adapter.notifyDataSetChanged()
            reset()
        }

        val confirmButton: Button = find(R.id.calculate_confirm_button)

        confirmButton.setOnClickListener { calculateScore() }
    }

    private fun saveGameData(items: MutableList<DragUser>) {
        val userList = items.map { it.user }

        userList.forEach {
            if (it.isBankerSideForThisRound) {
                it.totalScore += scoreBankerSidePerUser
            } else {
                it.totalScore += scoreNotBankerSidePerUser
            }
        }

        userList.forEach { it.isBankerSideForThisRound = false }


        val gameData = GameData(userList, round + 1)
        Log.d(javaClass.simpleName, "gameData after calculate: " + Gson().toJson(gameData))
        CommonLib.putGameInfo(Gson().toJson(gameData))
        reset()
    }

    private fun reset() {
        scoreBankerSide = 0.0
        scoreNotBankerSide = 0.0
        scoreBankerSidePerUser = 0.0
        scoreNotBankerSidePerUser = 0.0
        namesNotBankerSide.delete(0, namesNotBankerSide.length)
        namesBankerSide.delete(0, namesBankerSide.length)
    }

    private fun getNewAdapterItems(): MutableList<DragUser> {
        gameInfo = CommonLib.getGameInfo()
        round = gameInfo.round
        val list = gameInfo.users.sortedByDescending { it.totalScore }.mapIndexed { i, user -> DragUser(i, user) }
        return list.toMutableList()
    }

    private fun calculateScore() {
        val items = dragUserRankAdapter.items

        Log.d(javaClass.simpleName, Gson().toJson(items))

        items.forEachIndexed { i, dragUser ->
            dragUser.user.score = items.size.toDouble() - i
            Log.d(javaClass.simpleName, "user rank: ${i + 1} ... user score: ${dragUser.user.score}")
        }
        Log.d(javaClass.simpleName, Gson().toJson(items))
        if (items.count { it.user.isBankerSideForThisRound } == 0) {
            Log.d(javaClass.simpleName, "No Banker side players")
            snackBar("No Banker side? Are you sure?")
        } else {

            val bankSideList = items.filter { it.user.isBankerSideForThisRound }
            bankSideList.forEach {
                scoreBankerSide = scoreBankerSide + it.user.score
                namesBankerSide.append(it.user.avatar.avatarName.name).append("\n")
            }
            scoreBankerSidePerUser = scoreBankerSide / bankSideList.size
            bankSideList.forEach { it.user.score = scoreBankerSidePerUser }
            Log.d(javaClass.simpleName, "scoreBankerSide :$scoreBankerSide")
            Log.d(javaClass.simpleName, "scoreBankerSidePerUser :$scoreBankerSidePerUser")

            val notBankSideList = items.filterNot { it.user.isBankerSideForThisRound }
            notBankSideList.forEach {
                scoreNotBankerSide = scoreNotBankerSide + it.user.score
                namesNotBankerSide.append(it.user.avatar.avatarName.name).append("\n")
            }
            scoreNotBankerSidePerUser = scoreNotBankerSide / notBankSideList.size
            notBankSideList.forEach { it.user.score = scoreNotBankerSidePerUser }
            Log.d(javaClass.simpleName, "scoreNotBankerSide :$scoreNotBankerSide")
            Log.d(javaClass.simpleName, "scoreNotBankerSidePerUser :$scoreNotBankerSidePerUser")
            Log.d(javaClass.simpleName, Gson().toJson(items))

            val bankerSideResult = "bankerSide:\n" + namesBankerSide.toString() + "totalScore:" + scoreBankerSide
            val notBankerSideResult = "notBankerSide:\n" + namesNotBankerSide.toString() + "totalScore:" + scoreNotBankerSide

            alert("$bankerSideResult\n\n$notBankerSideResult", "Please check") {
                yesButton {
                    saveGameData(items)
                    finish()
                }
                noButton {
                    reset()
                }
            }.show()

        }
    }
}
