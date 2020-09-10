package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.model.Equity;
import com.snowcoder.stockwatcher.model.Sector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquityGenerator extends UninitializedStateHandler {

    private final Logger logger = LoggerFactory.getLogger(EquityGenerator.class);
    private SectorServiceImpl sectorService;

    @Override
    public void action(AppState appState) {
        if(!appState.getIsEquityTableFIlled()){
            List<Sector> sectors = sectorService.getAll();
            if(sectors.isEmpty()) sectors = enrichSectorName(sectors);
        }
    }

    private List<Sector> enrichSectorName(List<Sector> sectorList){
        sectorList.stream().forEach(s->s.getName().replaceAll("\\\\s+", ""));
        return sectorList;
    }

    private List<Equity> getSectorEquityList(List<Sector> sectorList){
        // call nse api
        // parse api response
        return new ArrayList<>();
    }

    @Autowired
    public void setSectorService(SectorServiceImpl sectorService) {
        this.sectorService = sectorService;
    }
}
