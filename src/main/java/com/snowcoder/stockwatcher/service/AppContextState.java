package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppState;

public interface AppContextState {

    AppState getAppState();

    boolean setUpState(AppState appState);
}
