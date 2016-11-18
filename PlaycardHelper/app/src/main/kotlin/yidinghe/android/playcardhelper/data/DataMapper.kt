package yidinghe.android.playcardhelper.data

/**
 * Created by yidinghe on 11/17/16.
 */


class DataMapper {

    fun convertFromAvatarToUser(list: List<Avatar>) = list.filter { it.isChecked }.map { User(it) }

    fun getAllUserName(list: List<User>): String {
        val sb = StringBuffer()
        list.forEach { sb.append(it.avatar.avatarName.name).append(", ") }
        sb.deleteCharAt(sb.lastIndex)
        sb.deleteCharAt(sb.lastIndex)
        return sb.toString()
    }
}