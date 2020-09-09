package com.snowcoder.stockwatcher.config;

import com.snowcoder.stockwatcher.service.AppContextState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.snowcoder.stockwatcher.enums.AppStates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ApplicationServiceFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceFactory.class);

    @Bean(name = "appStateSetUpMap")
    public Map<AppStates, AppContextState> appStateSetupMap(List<AppContextState> appContextStateList){
        LOGGER.info("============ Setting up ApplicationServiceFactory =================");
        HashMap<AppStates, AppContextState> appStateSetUpMap = new HashMap<>();
        appContextStateList.forEach(acst -> appStateSetUpMap.put(acst.getAppState(), acst));
        return appStateSetUpMap;
    }
}
