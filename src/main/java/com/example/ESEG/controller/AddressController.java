package com.example.ESEG.controller;


import com.example.ESEG.model.Address;
import com.example.ESEG.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddressController {

    private final AddressRepository repository;


    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("api/address")
    public Iterable<Address> findAll() {
        return repository.findAll();
    }

    @RequestMapping("api/address/{id}")
    public Address getAddress (@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping(value = "/api/address", consumes = "application/json", produces="application/json")
    public Address createAddress(@RequestBody Address address) {
        repository.save(address);
        return address;
    }

    @PutMapping(path="/api/address/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Address current= repository.findById(id).get();
        current.setTitle(body.get("title"));
        //current.setUserId(Long.parseLong(body.get("userId")));
        current.setLastName(body.get("lastName"));
        current.setFirstName(body.get("firstName"));
        current.setStreet(body.get("street"));
        current.setHouseNr(Integer.parseInt("houseNr"));
        current.setPlz(Integer.parseInt("plz"));
        current.setCity("city");
    }

    @PatchMapping(path="api/address/{id}")
    public void patchAddress(@PathVariable Long id, @RequestBody Map<String, Object> changes) {
        Address address= repository.findById(id).get();
        mapPersistenceModelToRestModel(address);
        changes.forEach(
                (change, value) ->{
                    switch (change){
                        case "title":   address.setTitle((String) value);
                                        repository.save(address);
                                        break;
                        case "userId":  address.setUserId((Long) value);
                                        repository.save(address);
                                        break;
                        case "lastName":address.setLastName((String) value);
                                        repository.save(address);
                                        break;
                        case "firstName":   address.setFirstName((String) value);
                                            repository.save(address);
                                            break;
                        case "street":  address.setStreet((String) value);
                                        repository.save(address);
                                        break;
                        case "houseNr": address.setHouseNr((Integer) value);
                                        repository.save(address);
                                        break;
                        case "plz":     address.setPlz((Integer) value);
                                        repository.save(address);
                                        break;
                        case "city":    address.setCity((String) value);
                                        repository.save(address);
                                        break;
                    }
                }
        );
    }

    @DeleteMapping("/api/address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public Address mapPersistenceModelToRestModel(Address address) {
        Address addressRestModel= new Address();
        addressRestModel.setId(address.getId());
        addressRestModel.setTitle(address.getTitle());
        addressRestModel.setUserId(address.getUserId());
        addressRestModel.setLastName((address.getLastName()));
        addressRestModel.setFirstName(address.getFirstName());
        addressRestModel.setStreet(address.getStreet());
        addressRestModel.setHouseNr(address.getHouseNr());
        addressRestModel.setPlz(address.getPlz());
        addressRestModel.setCity(address.getCity());
        return addressRestModel;
    }



}
