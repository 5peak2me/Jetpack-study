package com.daijinlin.study.jetpack.startup;

import android.util.Log;

public class Sdk2 {
    public static Sdk2 init() {
        Log.d("Jetpack", "init: Sdk2");
        return new Sdk2();
    }
}
