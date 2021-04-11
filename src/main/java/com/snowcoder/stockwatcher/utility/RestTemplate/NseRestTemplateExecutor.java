package com.snowcoder.stockwatcher.utility.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class NseRestTemplateExecutor {

    private static String baseUrl;

    private static final RestTemplate restTemplate = new RestTemplate();

    public static ResponseEntity execute(String uri, HttpMethod httpMethod, HttpEntity request) {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(uri);

        ResponseEntity<?> responseEntity;

        try {
            responseEntity = restTemplate.exchange(url.toString(), httpMethod, request, String.class);
        }catch(HttpClientErrorException e) {
            responseEntity = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }catch(HttpServerErrorException e) {
            responseEntity = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }catch(Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }
        return responseEntity;
    }

    @Autowired
    public static void setBaseUrl(@Value("${nse.equityApiBaseUrl}") String baseUrl) {
        NseRestTemplateExecutor.baseUrl = baseUrl;
    }
}
