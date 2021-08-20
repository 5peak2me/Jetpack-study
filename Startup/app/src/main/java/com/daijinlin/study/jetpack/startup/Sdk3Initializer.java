package com.daijinlin.study.jetpack.startup;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

public class Sdk3Initializer implements Initializer<Sdk3> {
    @NonNull
    @Override
    public Sdk3 create(@NonNull Context context) {
        return Sdk3.init();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
//        return Arrays.asList(Sdk1Initializer.class);
        return Collections.emptyList();
    }
}
