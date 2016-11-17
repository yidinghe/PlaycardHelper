package yidinghe.android.playcardhelper.data

/**
 * Created by yidinghe on 11/17/16.
 */


class DataMapper {

    fun convertFromAvatarToUser(list: List<Avatar>) = list.filter { it.isChecked }.map { User(it) }

}