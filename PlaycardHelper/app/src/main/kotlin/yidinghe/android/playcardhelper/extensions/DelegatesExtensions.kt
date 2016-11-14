package yidinghe.com.android.kotlin.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by yidinghe on 11/3/16.
 */

object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}

private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already init")
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not init")
    }

}