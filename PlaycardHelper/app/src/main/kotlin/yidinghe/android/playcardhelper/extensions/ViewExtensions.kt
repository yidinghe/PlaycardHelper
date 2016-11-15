package yidinghe.com.android.kotlin.extensions

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import org.jetbrains.anko.contentView
import org.jetbrains.anko.toast

/**
 * Created by yiding on 11/1/2016.
 */

val View.ctx: Context
    get() = context

fun Activity.snackBar(message: Int) = Snackbar.make(contentView!!, message, Snackbar.LENGTH_SHORT).show()
fun Activity.snackBar(message: CharSequence) = Snackbar.make(contentView!!, message, Snackbar.LENGTH_SHORT).show()
inline fun Fragment.snackBar(message: Int): Unit = activity.snackBar(message)
inline fun Fragment.snackBar(message: CharSequence): Unit = activity.snackBar(message)

fun Activity.longSnackBar(message: Int) = Snackbar.make(contentView!!, message, Snackbar.LENGTH_LONG).show()
fun Activity.longSnackBar(message: CharSequence) = Snackbar.make(contentView!!, message, Snackbar.LENGTH_LONG).show()
inline fun Fragment.longSnackBar(message: Int): Unit = activity.longSnackBar(message)
inline fun Fragment.longSnackBar(message: CharSequence): Unit = activity.longSnackBar(message)