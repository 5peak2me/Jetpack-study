package com.daijinlin.study.jetpack.startup;

import android.util.Log;

public class Sdk1 {
    public static Sdk1 init() {
        Log.d("Jetpack", "init: Sdk1");
        return new Sdk1();
    }
}
