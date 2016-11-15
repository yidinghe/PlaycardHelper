package yidinghe.android.playcardhelper.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_grid_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.UserAction
import yidinghe.com.android.kotlin.extensions.ctx

/**
 * Created by yiding on 11/14/2016.
 */


class UserActionGridAdapter(val items: List<UserAction>, val itemClick: (UserAction) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindUserAction(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.list_grid_item, parent, false)
        return ViewHolder(view, itemClick)
    }

}

class ViewHolder(view: View, val itemClick: (UserAction) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bindUserAction(userAction: UserAction) {

        with(userAction) {
            itemView.text_view.text = this.name
            itemView.text_view.setOnClickListener {
                Log.d(javaClass.simpleName, "click trigger")
                itemClick(this)
            }
        }

    }


}