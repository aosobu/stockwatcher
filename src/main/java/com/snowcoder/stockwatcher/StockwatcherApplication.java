package com.snowcoder.stockwatcher;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.repository.EquityMetricsRepository;
import com.snowcoder.stockwatcher.repository.EquityRepository;
import com.snowcoder.stockwatcher.repository.SectorRepository;
import com.snowcoder.stockwatcher.service.AppStateServiceImpl;
import com.snowcoder.webcrawlerlib.util.ScrapperUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication(scanBasePackages = "com.snowcoder")
public class StockwatcherApplication implements CommandLineRunner{
	@Autowired
	private ScrapperUtil scrapperUtil;
	Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private SectorRepository sectorRepository;

	@Autowired
	private EquityRepository equityRepository;

	@Autowired
	private EquityMetricsRepository equityMetricsRepository;

	@Autowired
    private AppStateServiceImpl appStateServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(StockwatcherApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	    //Procedure to get Categories and equities on NSE site
//		List<Node> nodes = new ArrayList<>();
//	    Document document = scrapperUtil.connect("http://www.nse.com.ng/market-data/trading-statistics/equities");
//		Elements elements = scrapperUtil.getElementsFromDocument(document, "#Sector");
//		for(Element element: elements)
//			nodes = element.childNodes();
//
//		for(Node n: nodes){
//            System.out.println("count me ++");
//			System.out.println(n);
//		}

//		Sector sector = new Sector();
//		sector.setName("Financial");
//		sectorRepository.save(sector);
//
//		Optional<Sector> sectorExists = sectorRepository.findByName("Financial");
//
//		Equity equity = new Equity();
//		equity.setName("teamapt");
//		equity.setTicker("TA");
//		equity.setSubSector("finctech");
//		if(sectorExists.isPresent()) {
//			System.out.println(sectorExists.get().getId());
//			equity.setSector(sectorExists.get());
//		}
//
//		Equity equityOne = new Equity();
//		equityOne.setName("teamapt");
//		equityOne.setTicker("TA");
//		equityOne.setSubSector("finctech");
//		if(sectorExists.isPresent()) {
//			System.out.println(sectorExists.get().getId());
//			equityOne.setSector(sectorExists.get());
//		}
//
//		equityRepository.save(equity);
//		equityRepository.save(equityOne);
	}
}
