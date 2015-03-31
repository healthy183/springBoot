package org.springBoot.batch3.annotation.processor;

import org.springBoot.batch3.annotation.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {

	public Person process(Person person) throws Exception {
		
		String  firstName = person.getFirstName().toUpperCase();
		String lastName   = person.getLastName().toUpperCase();
		Person rp = new Person(firstName,lastName);
		return rp;
	}

}
