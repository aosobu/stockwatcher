package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppState;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UninitializedAppStateService implements AppContextState {

    private final Logger logger = LoggerFactory.getLogger(UninitializedAppStateService.class);
    private ScrapperUtil scrapperUtil;
    private String scrapeSite;
    private String element;
    private SectorServiceImpl sectorServiceImpl;
    private final String REFLECTIONNAME = "names and creams";

    @Override
    public AppState getAppState() {
        return AppState.UNINITIALIZED;
    }

    /**
     * Todo: Use chain of command pattern to set up state
     * @return
     */
    @Override
    public boolean setUpState() {
        if(saveRetrievedSectors())
            System.out.println("// check if nse api endpoint is available");
        return false;
    }

    private boolean saveRetrievedSectors(){
        List retrievedSectors;
        retrievedSectors = getSectorListFromEquitySite(REFLECTIONNAME);
        return !retrievedSectors.isEmpty() ? sectorServiceImpl.saveAll(retrievedSectors) : false;
    }

    private List<Sector> getSectorListFromEquitySite(String reflectionName){
        List<Sector> sectors = new ArrayList<>();

        try {
            Document document = scrapperUtil.connect(scrapeSite);
            Elements elements = scrapperUtil.getElementsFromDocument(document, element);
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
    public void setScrapperUtil(ScrapperUtil scrapperUtil) {
        this.scrapperUtil = scrapperUtil;
    }

    @Autowired
    public void setScrapeSite(@Value("${nse.site}") String scrapeSite) {
        this.scrapeSite = scrapeSite;
    }

    @Autowired
    public void setElement(@Value("${nse.element}") String element) {
        this.element = element;
    }

    @Autowired
    public void setSectorServiceImpl(SectorServiceImpl sectorServiceImpl) {
        this.sectorServiceImpl = sectorServiceImpl;
    }
}
