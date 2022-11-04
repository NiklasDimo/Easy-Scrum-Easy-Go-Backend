package com.example.ESEG.controller;


import com.example.ESEG.model.Impressum;
import com.example.ESEG.model.Product;
import com.example.ESEG.repository.ImpressumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://Localhost:4200")
@RestController
public class ImpressumController {

    private final ImpressumRepository impressumRepository;

    public ImpressumController(ImpressumRepository impressumRepository) {
        this.impressumRepository = impressumRepository;
    }

    @RequestMapping("/api/impressum")
    public Iterable<Impressum> findAll(){
        return impressumRepository.findAll();
    }


    @PutMapping(path="/api/impressum/{id}")
    public void updateImpressum(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        Impressum current = impressumRepository.findById(id).get();
        current.setName(body.get("name"));
        current.setStr(body.get("str"));
        current.setPlz(body.get("plz"));
        current.setTelefon(body.get("telefon"));
        current.setTelefax(body.get("telefax"));
        current.setEmail(body.get("email"));
        impressumRepository.save(current);
    }

}
