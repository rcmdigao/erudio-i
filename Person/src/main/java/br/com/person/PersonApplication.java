package br.com.person;

import br.com.person.model.Person;
import br.com.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PersonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Autowired
	private PersonRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(List.of(
				new Person(null, "Rodrigo", "Machado", "Império dos Nobres", "Feminino"),
				new Person(null, "Ivanilde", "Cunha", "Império dos Nobres", "Feminino"),
				new Person(null, "Adailton", "Machado", "Império dos Nobres", "Masculino")
		));
	}

}
