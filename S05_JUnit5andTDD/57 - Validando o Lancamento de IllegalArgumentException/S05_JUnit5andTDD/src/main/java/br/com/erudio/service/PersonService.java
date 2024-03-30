package br.com.erudio.service;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.model.Person;

//criando a CLASSE PERSONSERVICE q ira implementar a INTERFACE IPERSONSERVICE
public class PersonService implements IPsersonService {

	
	//implementando o metodo CREATEPERSON q foi criado na INTERFACE IPERSONSERVICE
	@Override
	public Person createPerson(Person person) {
		if(person.getEmail() == null || person.getEmail().isBlank()) {
			throw new IllegalArgumentException("The Person e-Mail is null or empty");
		}

		var id = new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;
		
	}

}
