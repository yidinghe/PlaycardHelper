package yidinghe.android.playcardhelper.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by yiding on 11/14/2016.
 */

public class ChoiceAdapter extends RecyclerView.Adapter {

    private static String[] items = {"New Game", "Continue", "Rank", "Help", "About"};

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.length;
    }


}
