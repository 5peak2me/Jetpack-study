package com.daijinlin.study.jetpack.startup;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

public class Sdk2Initializer implements Initializer<Sdk2> {
    @NonNull
    @Override
    public Sdk2 create(@NonNull Context context) {
        return Sdk2.init();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
