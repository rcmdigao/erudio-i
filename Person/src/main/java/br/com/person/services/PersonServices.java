package br.com.person.services;


import br.com.person.exceptions.ResourceNotFoundException;
import br.com.person.model.Person;
import br.com.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName()); // Log
    @Autowired
    private PersonRepository repository;

    public List<Person> findAll(){
       logger.info("Listando pessoas");
       return repository.findAll();
    }

    public Person finById(Long id){

       logger.info("Procurando uma pessoa");
       return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
    }

    public Person create(Person person){
        logger.info("Cadastrando pessoa");
        return repository.save(person);
    }

    // Todo Update
    public Person update(Person person){
        logger.info("Atualizando pessoa");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
        entity.setPrimeiroNome(person.getPrimeiroNome());
        entity.setUltimoNome(person.getUltimoNome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        return repository.save(person);
    }


    public void delete(Long id){
        logger.info("Delete pessoa");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um registro para esse ID"));
        repository.delete(entity);
    }


}
