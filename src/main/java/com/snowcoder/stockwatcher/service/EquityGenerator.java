package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.model.Equity;
import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.stockwatcher.utility.RestTemplate.NseRestTemplateExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquityGenerator extends UninitializedStateHandler {

    private final Logger logger = LoggerFactory.getLogger(EquityGenerator.class);
    private SectorServiceImpl sectorService;
    private String equityApiParameter;
    private String uri;

    @Override
    public void action(AppState appState) {
        if(!appState.getIsEquityTableFIlled()){
            List<Sector> sectors = sectorService.getAll();
            if(sectors.isEmpty()) sectors = enrichSectorName(sectors);
            getSectorEquityList(sectors);
        }
    }

    private List<Sector> enrichSectorName(List<Sector> sectorList){
        sectorList.stream().forEach(s->s.getName().replaceAll("\\\\s+", ""));
        return sectorList;
    }

    private List<Equity> getSectorEquityList(List<Sector> sectorList){
        HttpHeaders headers = new HttpHeaders();
        sectorList.stream().forEach(sector -> {
            uri = enrichEquityApiParameter(equityApiParameter);
            ResponseEntity responseEntity = NseRestTemplateExecutor
                    .execute(uri, HttpMethod.GET, new HttpEntity<>(sector.getName(),headers));
        });
        return new ArrayList<>();
    }

    private String enrichEquityApiParameter(String equityApiParameter) {
        return "";
    }

    @Autowired
    public void setSectorService(SectorServiceImpl sectorService) {
        this.sectorService = sectorService;
    }

    public void setEquityApiParameter(String equityApiParameter) {
        this.equityApiParameter = equityApiParameter;
    }
}
