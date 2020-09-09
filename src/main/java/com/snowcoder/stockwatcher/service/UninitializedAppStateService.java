package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppStates;
import com.snowcoder.stockwatcher.model.AppState;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UninitializedAppStateService implements AppContextState {

    private final Logger logger = LoggerFactory.getLogger(UninitializedAppStateService.class);
    private AppStateServiceImpl appState;
    private StateAggregator stateAggregator;
    private SectorGenerator sectorGenerator;
    private EquityGenerator equityGenerator;

    @Override
    public AppStates getAppState() {
        return AppStates.UNINITIALIZED;
    }

    @Override
    public void setUpState() {
        List<AppState> appStates = appState.retrieveAppState();
        if(appStates.isEmpty())
            return;

        stateAggregator.setSuccessor(sectorGenerator);
        sectorGenerator.setSuccessor(equityGenerator);
        stateAggregator.action(appStates.get(0));
    }

    @Autowired
    public void setAppState(AppStateServiceImpl appState) {
        this.appState = appState;
    }

    @Autowired
    public void setStateAggregator(StateAggregator stateAggregator) {
        this.stateAggregator = stateAggregator;
    }

    @Autowired
    public void setSectorGenerator(SectorGenerator sectorGenerator) {
        this.sectorGenerator = sectorGenerator;
    }

    @Autowired
    public void setEquityGenerator(EquityGenerator equityGenerator) {
        this.equityGenerator = equityGenerator;
    }
}
