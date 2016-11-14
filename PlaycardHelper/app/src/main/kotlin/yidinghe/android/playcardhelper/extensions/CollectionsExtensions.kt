package yidinghe.com.android.kotlin.extensions

/**
 * Created by yidinghe on 11/4/16.
 */

fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
