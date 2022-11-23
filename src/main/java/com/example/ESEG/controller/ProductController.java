package com.example.ESEG.controller;

import com.example.ESEG.model.Product;
import com.example.ESEG.repository.ProductRepository;
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

    @PatchMapping(path="/api/product/{Id}")
    public void patchProduct(@PathVariable int Id, @RequestBody Map<String, Object> changes){
        Product product = repository.findById(Id).get();
        mapPersistenceModelToRestModel(product);
        changes.forEach(
                (change,value) ->{
                    switch (change){
                        case "name": product.setName((String) value); repository.save(product);
                            break;
                        case "description": product.setDescription((String) value); repository.save(product);
                            break;
                        case "category": product.setCategory((String) value); repository.save(product);
                            break;
                        case "price":  product.setPrice((Double) value); repository.save(product);
                            break;
                        case "currency": product.setCurrency((String) value); repository.save(product);
                            break;
                    }
                }
        );

    }


    // Method 1 Delete working
    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    private Product mapPersistenceModelToRestModel(Product product){
        Product productRestModel = new Product();
        productRestModel.setId(product.getId());
        productRestModel.setName(product.getName());
        productRestModel.setCategory(product.getCategory());
        productRestModel.setDescription(product.getDescription());
        productRestModel.setPrice(product.getPrice());
        productRestModel.setCurrency(product.getCurrency());
        return productRestModel;
    }

}
