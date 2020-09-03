package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InitializedAppStateService implements AppContextState {

    private final Logger LOGGER = LoggerFactory.getLogger(InitializedAppStateService.class);

    @Override
    public AppState getAppState() {
        return AppState.INITIALIZED;
    }

    @Override
    public boolean setUpState() {
        return true;
    }
}
