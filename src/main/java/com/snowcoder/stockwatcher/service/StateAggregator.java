package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import org.springframework.stereotype.Service;

@Service
public class StateAggregator extends UninitializedStateHandler {

    @Override
    public void action(AppState appState) {
        successor.action(appState);
    }
}
