package br.com.person.services;


import br.com.person.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServicesold {
    private final AtomicLong counter = new AtomicLong(); // Gerando numeros aleatorios
    private Logger logger = Logger.getLogger(PersonServicesold.class.getName()); // Log



    public List<Person> findAll(){

        logger.info("Listando pessoas");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++){
         Person person = mockPerson(i);
         persons.add(person);
        }

        return persons;
    }

    public Person finById(String id){

        logger.info("Procurando uma pessoa");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setPrimeiroNome("Rodrigo");
        person.setUltimoNome("Machado");
        person.setEndereco("Condominio Recanto dos Nobres");
        person.setGenero("Masculino");
        return person;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setPrimeiroNome("Primeiro nome " + i);
        person.setUltimoNome("Ultimo nome " + i);
        person.setEndereco("Endereço " + i);
        person.setGenero("Genero " + i);

        return person;
    }


    public Person create(Person person){
        logger.info("Cadastrando pessoa");
        return person;
    }

    public Person update(Person person){
        logger.info("Atualizando pessoa");
        return person;
    }


    public void delete(String id){
        logger.info("Delete pessoa");
    }


}
