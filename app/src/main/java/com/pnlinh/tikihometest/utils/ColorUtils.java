package com.pnlinh.tikihometest.utils;

import android.graphics.Color;

import java.util.Random;

public class ColorUtils {

    public static int randomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
