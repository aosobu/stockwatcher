package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppStates;

public interface AppContextState {

    AppStates getAppState();

    void setUpState();
}
