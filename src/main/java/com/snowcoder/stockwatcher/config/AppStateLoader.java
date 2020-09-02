package com.snowcoder.stockwatcher.config;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.service.AppStateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
@DependsOn("appStateSetUpMap")
public class AppStateLoader{

    private AppStateServiceImpl appStateServiceImpl;
    private final Logger LOGGER = LoggerFactory.getLogger(AppStateLoader.class);

    @Bean
    public void checkAppState(){
        LOGGER.info("============ Setting up AppStateLoader =================");
        LOGGER.info("============ CHECKING APP STATE =================");
        List<AppState> appState = appStateServiceImpl.retrieveAppState();
        if(appState.isEmpty()) {
            // initiate app set up
            LOGGER.info("============ INITIALIZING APPs =================");
        }
    }

    @Autowired
    public void setAppStateServiceImpl(AppStateServiceImpl appStateServiceImpl) {
        this.appStateServiceImpl = appStateServiceImpl;
    }
}
