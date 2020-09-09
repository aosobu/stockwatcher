package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EquityGenerator extends UninitializedStateHandler {

    private final Logger logger = LoggerFactory.getLogger(EquityGenerator.class);

    @Override
    public void action(AppState appState) {
        if(!appState.getIsEquityTableFIlled()){
            logger.info("about to retrieve equity");
        }
        return;
    }
}
