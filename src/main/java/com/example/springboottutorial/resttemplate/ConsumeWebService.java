package com.example.springboottutorial.resttemplate;

import java.text.MessageFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboottutorial.product.domain.Product;

@RestController
public class ConsumeWebService {

    private final String requestUrl = "http://localhost:{0}/products/";

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/templates/products")
    public String getProductList() {
        HttpEntity<String> entity = new HttpEntity<>(createHeadersWithJson());
        return restTemplate.exchange(MessageFormat.format(requestUrl, port), HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/templates/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product) {
        HttpEntity<String> entity = new HttpEntity<>(createHeadersWithJson());
        return restTemplate.exchange(MessageFormat.format(requestUrl, port), HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/templates/products/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpEntity<Product> entity = new HttpEntity<>(product, createHeadersWithJson());
        return restTemplate.exchange(MessageFormat.format(requestUrl, port).concat(id), HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/templates/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpEntity<Product> entity = new HttpEntity<>(createHeadersWithJson());
        return restTemplate.exchange(MessageFormat.format(requestUrl, port).concat(id), HttpMethod.DELETE, entity, String.class).getBody();
    }

    private HttpHeaders createHeadersWithJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
