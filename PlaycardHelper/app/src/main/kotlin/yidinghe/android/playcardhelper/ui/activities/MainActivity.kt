package yidinghe.android.playcardhelper.ui.activities

import android.graphics.drawable.NinePatchDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.h6ah4i.android.widget.advrecyclerview.decoration.ItemShadowDecorator
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
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
            Log.d(javaClass.simpleName, "click trigger callback")
            toast(it.name)
        }
        userActionRecyclerView.addItemDecoration(ItemShadowDecorator(getDrawable(R.drawable.material_shadow_z1) as NinePatchDrawable))

    }

    private fun initData(): List<UserAction> =
            listOf(UserAction.NEW_GAME, UserAction.CONTINUE, UserAction.RANK, UserAction.HELP, UserAction.ABOUT)

}
