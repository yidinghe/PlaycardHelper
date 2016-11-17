package yidinghe.android.playcardhelper.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_grid_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.UserAction
import yidinghe.android.playcardhelper.data.loadBackgroundImage
import yidinghe.com.android.kotlin.extensions.ctx

/**
 * Created by yiding on 11/14/2016.
 */


class UserActionGridAdapter(val items: List<UserAction>, val itemClick: (UserAction) -> Unit) : RecyclerView.Adapter<UserActionViewHolder>() {

    override fun onBindViewHolder(holder: UserActionViewHolder?, position: Int) {
        holder?.bindUserAction(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserActionViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.list_grid_item, parent, false)
        return UserActionViewHolder(view, itemClick)
    }

}

class UserActionViewHolder(view: View, val itemClick: (UserAction) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bindUserAction(userAction: UserAction) {

        with(userAction) {
            itemView.user_action_text_view.text = this.name
            userAction.loadBackgroundImage(itemView.user_action_image_view)

            itemView.user_action_container.setOnClickListener {
                Log.d(javaClass.simpleName, "click trigger")
                itemClick(this)
            }
        }

    }


}