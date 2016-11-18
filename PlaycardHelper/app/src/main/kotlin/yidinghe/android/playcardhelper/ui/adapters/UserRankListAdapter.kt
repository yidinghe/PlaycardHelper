package yidinghe.android.playcardhelper.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_grid_avatar_item.view.*
import kotlinx.android.synthetic.main.list_grid_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.*
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.ctx

/**
 * Created by yiding on 11/14/2016.
 */


class UserRankListAdapter(val items: List<User>) : RecyclerView.Adapter<UserRankViewHolder>() {

    override fun onBindViewHolder(holder: UserRankViewHolder?, position: Int) {
        holder?.bindUser(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserRankViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.list_grid_avatar_item, parent, false)
        return UserRankViewHolder(view)
    }


}

class UserRankViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindUser(user: User) {

        itemView.avatar_text_view.text = user.avatar.avatarName.name
    }

}