package com.daijinlin.study.jetpack.startup;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

public class Sdk1Initializer implements Initializer<Sdk1> {
    @NonNull
    @Override
    public Sdk1 create(@NonNull Context context) {
        return Sdk1.init();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
//        return Collections.singletonList(Sdk2Initializer.class);
        return Collections.emptyList();
    }
}
