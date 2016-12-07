package yidinghe.com.android.kotlin.extensions

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
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

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadUrl(url: String) = Picasso.with(context).load(url).into(this)

fun ImageView.loadRes(@DrawableRes drawableRes: Int) = Picasso.with(context).load(drawableRes).into(this)