package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UninitializedAppStateService implements AppContextState {

    private final Logger logger = LoggerFactory.getLogger(UninitializedAppStateService.class);

    @Override
    public AppState getAppState() {
        return AppState.UNINITIALIZED;
    }

    @Override
    public boolean setUpState(AppState appState) {
        return false;
    }
}
