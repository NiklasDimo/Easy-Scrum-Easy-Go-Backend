package com.example.ESEG.controller;

import com.example.ESEG.model.Details;
import com.example.ESEG.model.Product;
import com.example.ESEG.repository.DetailsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class DetailsController {

    private final DetailsRepository repository;

    public DetailsController(DetailsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/api/details")
    public Iterable<Details> findAll(){

        return repository.findAll();
    }

    @RequestMapping("api/details/{productId}")
    public Details getDetails(@PathVariable Long productId, @RequestBody Map<String, String> body) {
        return repository.findByProductId(productId);
    }

    @PostMapping(value="/api/details", consumes="application/json", produces="application/json")
    public  Details createDetail(@RequestBody Details details) {
        repository.save(details);
        return details;
    }

    @PutMapping(path="/api/details/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Details current = repository.findById(id).get();
        current.setTitle(body.get("title"));
        current.setDescription(body.get("description"));
        repository.save(current);

    }

    @DeleteMapping("api/details/{id}")
    public void deleteDetail(@PathVariable Long id) {
        repository.deleteById(id);

    }


}
