package yidinghe.android.playcardhelper.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Button
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import yidinghe.android.playcardhelper.R
import yidinghe.com.android.kotlin.extensions.snackBar

class GameBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)

        val calculateButton: Button = find(R.id.calculate_button)

        calculateButton.setOnClickListener {
            startActivity<CalculatorActivity>()
        }

        snackBar("GameBoardActivity")
    }
}
