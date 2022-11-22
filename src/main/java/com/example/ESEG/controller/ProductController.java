package com.example.ESEG.controller;

import com.example.ESEG.model.Product;
import com.example.ESEG.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
//@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository repository;


    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    //Get Product
    @RequestMapping("/api/product")
    public Iterable<Product> findAll(){
        return repository.findAll();
    }
    //Get Variante 2
    //@GetMapping
    //public Iterable<Product> findAll() {
    //     return repository.findAll();
    //}


/*  Method 1 not working Get Request Product by Id
    @GetMapping("api/product/{id}")
    public getProductById(@PathVariable("id") Integer id) {
        return repository.findById(id).get();
    }
*/

    //Method 2 not working Get Request Product by Id
    @RequestMapping("api/product/{id}")
    public Product getProduct (@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }


    /*
    //Test
    @PostMapping("/api/product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

    //Post Product
    //@RequestMapping(method=RequestMethod.POST, value="/api/product")
    @PostMapping(value="/api/product", consumes="application/json", produces="application/json")
    public Product createProduct(@RequestBody Product product) {
        repository.save(product);
        return product;

    }

/*
    //Put or Update Product
    @RequestMapping(method=RequestMethod.PUT, value="/api/product/{id}")
    public void updateProduct (@PathVariable int id,@RequestBody Product product) {
        //repository.findById(id);

        //repository.save(product);
        Product current = repository.findById(id).get();
        repository.save(current);

    }
    */

    @PutMapping(path="/api/product/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        Product current = repository.findById(id).get();
        current.setName(body.get("name"));
        current.setCurrency(body.get("currency"));
        current.setPrice(Double.parseDouble(body.get("price")));
        current.setDescription(body.get("description"));
        current.setCategory(body.get("category"));
        repository.save(current);

    }

    /*
    @PatchMapping("id")
    ResponseEntity<T> patch(@PathVariable Integer id, RequestBody Map<Object, Object>)
    */


    // Method 1 Delete working
    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }
/*
    //Method 2 Delete working
    @RequestMapping(method=RequestMethod.DELETE, value="/api/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }
*/

}
