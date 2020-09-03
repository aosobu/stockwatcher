package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.enums.AppState;
import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.stockwatcher.repository.SectorRepository;
import com.snowcoder.webcrawlerlib.util.ScrapperUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UninitializedAppStateService implements AppContextState {

    private final Logger logger = LoggerFactory.getLogger(UninitializedAppStateService.class);
    private ScrapperUtil scrapperUtil;
    private String scrapeSite;
    private String element;
    private SectorServiceImpl sectorServiceImpl;

    @Override
    public AppState getAppState() {
        return AppState.UNINITIALIZED;
    }

    @Override
    public boolean setUpState() {

        List<Sector> sectors = sectorServiceImpl.saveAll(getSectors());

        // check if nse api endpoint is available
        // get all equity using nse endpoint
        // return true if procedure succeeds
        return false;
    }

    private List<Sector> getSectors(){
        Document document = scrapperUtil.connect(scrapeSite);
        Elements elements = scrapperUtil.getElementsFromDocument(document, element);
        List<Node> nodes = scrapperUtil.getNodesFromElement(elements);
        List<Sector> sectors = scrapperUtil.returnObjectsFromNodes(nodes, Sector.class, new ArrayList<String>());
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
