package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;

public abstract class UninitializedStateHandler {

    protected UninitializedStateHandler successor;

    public void setSuccessor(UninitializedStateHandler successor) {
        this.successor = successor;
    }

    public abstract void action(AppState appState);
}
