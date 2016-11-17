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


class AvatarGridAdapter(val items: List<Avatar>, val itemClick: (Avatar) -> Unit) : RecyclerView.Adapter<AvatarViewHolder>() {

    override fun onBindViewHolder(holder: AvatarViewHolder?, position: Int) {
        holder?.bindAvatar(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AvatarViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.list_grid_avatar_item, parent, false)
        return AvatarViewHolder(view, itemClick)
    }

}

class AvatarViewHolder(view: View, val itemClick: (Avatar) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bindAvatar(avatar: Avatar) {

        with(avatar) {
            itemView.avatar_text_view.text = this.avatarName.name
            avatar.loadBackgroundImage(itemView.avatar_background_image_view)
            avatar.loadAvatarImage(itemView.avatar_image_view)

            itemView.avatar_container.setOnClickListener {
                Log.d(javaClass.simpleName, "click trigger")
                itemClick(this)
            }
        }

    }

}