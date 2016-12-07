package yidinghe.android.playcardhelper.ui.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_grid_avatar_item.view.*
import kotlinx.android.synthetic.main.list_grid_item.view.*
import kotlinx.android.synthetic.main.list_rank_item.view.*
import yidinghe.android.playcardhelper.R
import yidinghe.android.playcardhelper.data.*
import yidinghe.android.playcardhelper.utils.CommonLib
import yidinghe.com.android.kotlin.extensions.ctx
import yidinghe.com.android.kotlin.extensions.inflate

/**
 * Created by yiding on 11/14/2016.
 */


class DragUserRankListAdapter(var items: MutableList<DragUser>) : RecyclerView.Adapter<DragUserRankViewHolder>(), DraggableItemAdapter<DragUserRankViewHolder> {

    fun changeItems(items: MutableList<DragUser>) {
        this.items = items
    }


    init {
        setHasStableIds(true)
    }

    override fun onMoveItem(fromPosition: Int, toPosition: Int) {
        val movedItem = items.removeAt(fromPosition)
        items.add(toPosition, movedItem)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onCheckCanStartDrag(holder: DragUserRankViewHolder?, position: Int, x: Int, y: Int): Boolean {
        return true
    }

    override fun onGetItemDraggableRange(holder: DragUserRankViewHolder?, position: Int): ItemDraggableRange {
        return ItemDraggableRange(0, itemCount - 1)
    }

    override fun onCheckCanDrop(draggingPosition: Int, dropPosition: Int): Boolean {
        return true
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun onBindViewHolder(holder: DragUserRankViewHolder?, position: Int) {
        holder?.bindUser(items[position], position)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DragUserRankViewHolder {
        val view = parent?.inflate(R.layout.list_rank_item)
        return DragUserRankViewHolder(view!!)
    }


}

class DragUserRankViewHolder(itemView: View) : AbstractDraggableItemViewHolder(itemView) {

    fun bindUser(dragUser: DragUser, position: Int) {
        itemView.rank_name_text.text = dragUser.user.avatar.avatarName.name
        itemView.rank_score_text.text = "isBankerSide:"

        dragUser.user.avatar.loadBackgroundImage(itemView.rank_background_image_view)
        dragUser.user.avatar.loadAvatarImage(itemView.rank_avatar_image_view)
        dragUser.user.loadRankImage(itemView.rank_rank_image_view, position)
        dragUser.user.loadCheckMark(itemView.rank_is_banker_side_image_view)

        itemView.rank_container.setOnClickListener {
            dragUser.user.isBankerSideForThisRound = !dragUser.user.isBankerSideForThisRound
            dragUser.user.loadCheckMark(itemView.rank_is_banker_side_image_view)
        }
    }

}