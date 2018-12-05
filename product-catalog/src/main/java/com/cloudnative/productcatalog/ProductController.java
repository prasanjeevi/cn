package com.cloudnative.productcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping( value = "/products")
public class ProductController {

    ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> products() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product products(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product add(@RequestBody Product product) {
        return repository.save(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product update(@RequestBody Product product) {
        return repository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
    
    @Cacheable(value = "products-top")
    @RequestMapping(value = "top", method = RequestMethod.GET)
    public Iterable<Product> top() {
        System.out.println("CACHE MISS");
        return repository.topProducts();
    }
}