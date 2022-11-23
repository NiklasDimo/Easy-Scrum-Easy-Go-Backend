package com.example.ESEG.controller;


import com.example.ESEG.model.Impressum;
import com.example.ESEG.model.Product;
import com.example.ESEG.model.User;
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

    @PatchMapping(path="/api/impressum/{Id}")
    public void patchImpressum(@PathVariable int Id, @RequestBody Map<String, Object> changes){
        Impressum impressum = impressumRepository.findById(Id).get();
        mapPersistenceModelToRestModel(impressum);
        changes.forEach(
                (change,value) ->{
                    switch (change){
                        case "name": impressum.setName((String) value); impressumRepository.save(impressum);
                            break;
                        case "str": impressum.setStr((String) value); impressumRepository.save(impressum);
                            break;
                        case "plz": impressum.setPlz((String) value); impressumRepository.save(impressum);
                            break;
                        case "telefon":  impressum.setTelefon((String) value); impressumRepository.save(impressum);
                            break;
                        case "telefax": impressum.setTelefax((String) value); impressumRepository.save(impressum);
                            break;
                        case "email": impressum.setEmail((String) value); impressumRepository.save(impressum);
                            break;
                    }
                }
        );

    }



    private Impressum mapPersistenceModelToRestModel(Impressum impressum){
        Impressum impressumRestModel = new Impressum();
        impressumRestModel.setId(impressum.getId());
        impressumRestModel.setName(impressum.getName());
        impressumRestModel.setStr(impressum.getStr());
        impressumRestModel.setPlz(impressum.getPlz());
        impressumRestModel.setTelefon(impressum.getTelefon());
        impressumRestModel.setTelefax(impressum.getTelefax());
        impressumRestModel.setEmail(impressum.getEmail());
        return impressumRestModel;
    }

}
