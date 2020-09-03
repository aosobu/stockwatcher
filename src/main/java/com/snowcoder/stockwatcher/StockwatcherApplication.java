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
public class StockwatcherApplication{
	public static void main(String[] args) {
		SpringApplication.run(StockwatcherApplication.class, args);
	}
}
