package com.snowcoder.stockwatcher;

import com.snowcoder.stockwatcher.config.ResourceLoader;
import com.snowcoder.stockwatcher.model.Equity;
import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.stockwatcher.repository.EquityRepository;
import com.snowcoder.stockwatcher.repository.SectorRepository;
import com.snowcoder.webcrawlerlib.util.ScrapperUtil;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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

	public static void main(String[] args) {
		SpringApplication.run(StockwatcherApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	    // Document document = scrapperUtil.connect("http://www.nse.com.ng/market-data/trading-statistics/equities");
		// scrapperUtil.getElementsFromDocument(document, "table.table.table-striped.table-hover tr");

//		Sector sector = new Sector();
//		sector.setName("Agriculture");
//
//		Set<Equity> equities = new HashSet<>();
//
//		Equity agricOne = new Equity();
//		agricOne.setName("OKOMU OIL PALM PLC");
//		agricOne.setTicker("LIVESTOCK");
//		agricOne.setSubSector("Crop Production");
//		agricOne.setCreated_on(new Date());
//
//		Equity agricTwo = new Equity();
//		agricTwo.setName("OKOMU OIL PALM PLC");
//		agricTwo.setTicker("LIVESTOCK");
//		agricTwo.setSubSector("Crop Production");
//		agricTwo.setCreated_on(new Date());
//
//		equities.add(agricOne);
//		equities.add(agricTwo);
//
//		equityRepository.save(agricOne);
//		equityRepository.save(agricTwo);
//
//		sector.setEquities(equities);
//		sectorRepository.save(sector);
//
//		Sector sectorOne = new Sector();
//		sectorOne.setName("Finance");
//
//		Set<Equity> equitiesFinance = new HashSet<>();
//
//		Equity agricThree = new Equity();
//		agricThree.setName("Zenith Bank");
//		agricThree.setTicker("ZENITH");
//		agricThree.setSubSector("Banking");
//		agricThree.setCreated_on(new Date());
//
//		Equity agricFour = new Equity();
//		agricFour.setName("First Bank");
//		agricFour.setTicker("FBN");
//		agricFour.setSubSector("Banking");
//		agricFour.setCreated_on(new Date());
//
//		equitiesFinance.add(agricThree);
//		equitiesFinance.add(agricFour);
//
//		equityRepository.save(agricThree);
//		equityRepository.save(agricFour);
//
//		sectorOne.setEquities(equitiesFinance);
//		sectorRepository.save(sectorOne);

	}
}
