package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InitializedAppStateService implements AppContextState {

    private final Logger LOGGER = LoggerFactory.getLogger(InitializedAppStateService.class);

    @Override
    public AppStates getAppState() {
        return AppStates.INITIALIZED;
    }

    @Override
    public void setUpState() {
        return;
    }
}
