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
import yidinghe.android.playcardhelper.data.Avatar
import yidinghe.android.playcardhelper.data.AvatarName
import yidinghe.android.playcardhelper.data.UserAction
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

            when (avatar.avatarName) {

                AvatarName.BIRD -> Picasso.with(CommonLib.getApp()).load(R.mipmap.bird).into(itemView.avatar_image_view)
                AvatarName.CAT -> Picasso.with(CommonLib.getApp()).load(R.mipmap.cat).into(itemView.avatar_image_view)
                AvatarName.CHICKEN -> Picasso.with(CommonLib.getApp()).load(R.mipmap.chicken).into(itemView.avatar_image_view)
                AvatarName.DOG -> Picasso.with(CommonLib.getApp()).load(R.mipmap.dog).into(itemView.avatar_image_view)
                AvatarName.DUCK -> Picasso.with(CommonLib.getApp()).load(R.mipmap.duck).into(itemView.avatar_image_view)
                AvatarName.FISH -> Picasso.with(CommonLib.getApp()).load(R.mipmap.fish).into(itemView.avatar_image_view)
                AvatarName.GOAT -> Picasso.with(CommonLib.getApp()).load(R.mipmap.goat).into(itemView.avatar_image_view)
                AvatarName.HIPPO -> Picasso.with(CommonLib.getApp()).load(R.mipmap.hippo).into(itemView.avatar_image_view)
                AvatarName.HORSE -> Picasso.with(CommonLib.getApp()).load(R.mipmap.horse).into(itemView.avatar_image_view)
                AvatarName.LAMB -> Picasso.with(CommonLib.getApp()).load(R.mipmap.lamb).into(itemView.avatar_image_view)
                AvatarName.LION -> Picasso.with(CommonLib.getApp()).load(R.mipmap.lion).into(itemView.avatar_image_view)
                AvatarName.MONKEY -> Picasso.with(CommonLib.getApp()).load(R.mipmap.monkey).into(itemView.avatar_image_view)
                AvatarName.MOUSE -> Picasso.with(CommonLib.getApp()).load(R.mipmap.mouse).into(itemView.avatar_image_view)
                AvatarName.OWL -> Picasso.with(CommonLib.getApp()).load(R.mipmap.owl).into(itemView.avatar_image_view)
                AvatarName.PIG -> Picasso.with(CommonLib.getApp()).load(R.mipmap.pig).into(itemView.avatar_image_view)
                AvatarName.REDPANDA -> Picasso.with(CommonLib.getApp()).load(R.mipmap.redpanda).into(itemView.avatar_image_view)
                AvatarName.TIGER -> Picasso.with(CommonLib.getApp()).load(R.mipmap.tiger).into(itemView.avatar_image_view)
                AvatarName.WOLF -> Picasso.with(CommonLib.getApp()).load(R.mipmap.wolf).into(itemView.avatar_image_view)

            }

            itemView.avatar_container.setOnClickListener {
                Log.d(javaClass.simpleName, "click trigger")
                itemClick(this)
            }
        }

    }


}