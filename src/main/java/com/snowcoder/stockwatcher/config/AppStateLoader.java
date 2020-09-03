package com.snowcoder.stockwatcher.config;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.service.AppContextState;
import com.snowcoder.stockwatcher.service.AppStateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Configuration
@DependsOn("appStateSetUpMap")
public class AppStateLoader{

    private AppStateServiceImpl appStateServiceImpl;
    private final Logger LOGGER = LoggerFactory.getLogger(AppStateLoader.class);
    private Map<com.snowcoder.stockwatcher.enums.AppState, AppContextState> appStateSetUpMap;


    @Bean
    public void checkAppState(){
        LOGGER.info("============ Setting up AppStateLoader =================");
        List<AppState> appState = appStateServiceImpl.retrieveAppState();
        if(appState.isEmpty() || !appState.get(0).getDatabaseIsFilled()) {
            appStateSetUpMap.get(com.snowcoder.stockwatcher.enums.AppState.UNINITIALIZED).setUpState();
            return;
        }
        appStateSetUpMap.get(com.snowcoder.stockwatcher.enums.AppState.INITIALIZED).setUpState();
    }

    @Autowired
    public void setAppStateServiceImpl(AppStateServiceImpl appStateServiceImpl) {
        this.appStateServiceImpl = appStateServiceImpl;
    }

    @Resource
    public void setAppStateSetUpMap(Map<com.snowcoder.stockwatcher.enums.AppState, AppContextState> appStateSetUpMap) {
        this.appStateSetUpMap = appStateSetUpMap;
    }
}
