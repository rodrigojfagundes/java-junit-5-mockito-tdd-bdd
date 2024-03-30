package br.com.erudio.service;

import br.com.erudio.model.Person;

//criando a CLASSE PERSONSERVICE q ira implementar a INTERFACE IPERSONSERVICE
//
public class PersonService implements IPsersonService {

	
	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		return new Person();
		
	}

}
