package com.example.springboottutorial.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottutorial.product.domain.Product;
import com.example.springboottutorial.product.exception.ProductNotFoundException;

@RestController
public class ProductServiceController {

    private static final Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        ProductServiceController.productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        honey.setId("2");
        honey.setName("Almond");
        ProductServiceController.productRepo.put(almond.getId(), almond);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(ProductServiceController.productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        ProductServiceController.productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfilly", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if (!ProductServiceController.productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        ProductServiceController.productRepo.remove(id);
        product.setId(id);
        ProductServiceController.productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        ProductServiceController.productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

}
