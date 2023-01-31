package br.com.services;

import br.com.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong(); // Gerando numeros aleatorios
    private Logger logger = Logger.getLogger(PersonServices.class.getName()); // Log

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



}
