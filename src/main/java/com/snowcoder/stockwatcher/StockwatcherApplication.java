package com.snowcoder.stockwatcher;

import com.snowcoder.webcrawlerlib.util.ScrapperUtil;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.snowcoder")
public class StockwatcherApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private ScrapperUtil scrapperUtil;

	public static void main(String[] args) {
		SpringApplication.run(StockwatcherApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Document document = scrapperUtil.connect("https://www.signetng.com/?pg=news");
		scrapperUtil.getElementsFromDocument(document, "table.table.table-striped.table-hover tr");
	}
}
