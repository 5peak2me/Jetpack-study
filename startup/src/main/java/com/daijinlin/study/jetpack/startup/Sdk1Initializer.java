package com.daijinlin.study.jetpack.startup;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

class Sdk1Initializer implements Initializer<Sdk1> {
    @NonNull
    @Override
    public Sdk1 create(@NonNull Context context) {
        return null;
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return null;
    }
}