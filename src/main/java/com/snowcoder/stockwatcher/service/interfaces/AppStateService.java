package com.snowcoder.stockwatcher.service.interfaces;

import com.snowcoder.stockwatcher.model.AppState;

import java.util.List;

public interface AppStateService {

    List<AppState> retrieveAppState();
}
