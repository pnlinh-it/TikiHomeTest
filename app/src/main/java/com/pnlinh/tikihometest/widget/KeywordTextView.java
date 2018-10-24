package com.pnlinh.tikihometest.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.pnlinh.tikihometest.utils.ColorUtils;
import com.pnlinh.tikihometest.utils.ViewUtils;

public class KeywordTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String TAG = KeywordTextView.class.getSimpleName();

    private static final float ROUND_RADIUS = 3f;

    public KeywordTextView(Context context) {
        this(context, null);
    }

    public KeywordTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLines(2);
        initBackground(context);
    }

    private void initBackground(Context context) {
        GradientDrawable bgDrawable = new GradientDrawable();
        bgDrawable.setColor(ColorUtils.randomColor());
        bgDrawable.setCornerRadius(ViewUtils.dpToPx(ROUND_RADIUS, context));
        setBackgroundDrawable(bgDrawable);
    }

    /**
     * Insert \n character in to center index
     */
    private String formatText(String keyword) {
        if (TextUtils.isEmpty(keyword) || !keyword.contains(" "))
            return keyword;

        keyword = keyword.replace("\n", " ");
        String left = "", right = "";
        for (int i = keyword.length() - 1; i >= 0; i--)
            if (keyword.charAt(i) == ' ') {
                left = keyword.substring(0, i).trim();
                right = keyword.substring(i).trim();
                if (right.length() >= left.length()) {
                    break;
                }
            }
        return String.format("%s\n%s", left, right);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(formatText(String.valueOf(text)), type);
    }
}
