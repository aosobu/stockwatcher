package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.webcrawlerlib.util.ScrapperUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectorGenerator extends UninitializedStateHandler {

    private final Logger logger = LoggerFactory.getLogger(SectorGenerator.class);
    private ScrapperUtil scrapperUtil;
    private String scrapeSite;
    private String sectorDomElement;
    private SectorServiceImpl sectorServiceImpl;

    @Override
    public void action(AppState appState) {
        String REFLECTIONNAME = "name"; // move to configuration
        if(!appState.getIsSectorTableFilled()) {
            List<Sector> retrievedSectors;
            retrievedSectors = getSectorListFromEquitySite(REFLECTIONNAME);
            if(!retrievedSectors.isEmpty()) {
                sectorServiceImpl.saveAll(retrievedSectors);
                appState.setIsSectorTableFilled(true);
            }
        }
        successor.action(appState);
    }

    private List<Sector> getSectorListFromEquitySite(String reflectionName){
        List<Sector> sectors = new ArrayList<>();

        try {
            Document document = scrapperUtil.connect(scrapeSite);
            Elements elements = scrapperUtil.getElementsFromDocument(document, sectorDomElement);
            List<Node> nodes = scrapperUtil.getNodesFromElement(elements);
            return scrapperUtil.returnObjectsFromNodes(nodes, Sector.class, reflectionName, 0)
                    .stream()
                    .filter(s->!s.getName().contains("All Sector"))
                    .collect(Collectors.toList());
        }catch(Exception e){
            logger.info("error generating list of " + Sector.class.toString() + " " + e.getMessage());
        }

        return sectors;
    }

    @Autowired
    public void setScrapeSite(@Value("${nse.site}") String scrapeSite) {
        this.scrapeSite = scrapeSite;
    }

    @Autowired
    public void setElement(@Value("${nse.sectorElement}") String sectorDomElement) {
        this.sectorDomElement = sectorDomElement;
    }

    @Autowired
    public void setSectorServiceImpl(SectorServiceImpl sectorServiceImpl) {
        this.sectorServiceImpl = sectorServiceImpl;
    }

    @Autowired
    public void setScrapperUtil(ScrapperUtil scrapperUtil) {
        this.scrapperUtil = scrapperUtil;
    }
}
