package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import org.jetbrains.anko.contentView
import yidinghe.android.playcardhelper.R
import yidinghe.com.android.kotlin.extensions.snackBar

class RankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        snackBar("RankActivity")
    }
}
