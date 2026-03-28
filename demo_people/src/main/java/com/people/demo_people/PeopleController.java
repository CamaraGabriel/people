package com.people.demo_people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.people.demo_people.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/people")

public class PeopleController {

    @Autowired
    private PeopleRepository repository; 

    @GetMapping
    public List<PeopleModel> getAll() {
        System.out.println("Visualização bem sucedida!");
        return repository.findAll(); 
    }

    @PostMapping
    public PeopleModel create(@RequestBody PeopleModel people) { 
        System.out.println("Pessoa inserida com sucesso!");
        return repository.save(people); 
    } 

    @PutMapping("/{id}")
    public PeopleModel atualizar(@PathVariable Long id, @RequestBody PeopleModel f) {
        f.setId(id); // Se o ID já existe, o save() do JPA funciona como Update

        return repository.save(f);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}


