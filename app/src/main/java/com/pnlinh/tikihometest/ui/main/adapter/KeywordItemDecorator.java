package com.pnlinh.tikihometest.ui.main.adapter;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pnlinh.tikihometest.utils.ViewUtils;

public class KeywordItemDecorator extends RecyclerView.ItemDecoration {
    private static final int MARGIN_TOP = 8;

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.left = 0;
        else
            outRect.left = ((int) ViewUtils.dpToPx(MARGIN_TOP, parent.getContext()));
    }
}
