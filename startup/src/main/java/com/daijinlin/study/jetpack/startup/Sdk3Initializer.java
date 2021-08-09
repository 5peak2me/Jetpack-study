package com.daijinlin.study.jetpack.startup;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

class Sdk3Initializer implements Initializer<Sdk3> {
    @NonNull
    @Override
    public Sdk3 create(@NonNull Context context) {
        return null;
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return null;
    }
}
