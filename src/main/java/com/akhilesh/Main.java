package com.akhilesh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akhilesh.model.Person;
import com.akhilesh.spring.config.AppConfig;
import com.akhilesh.spring.dao.PersonDAO;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println("List of person is:");
        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        System.out.println("\nGet person with ID 1");
        Person personById = personDAO.getPersonById(1L);
        System.out.println(personById);



        System.out.println("\nCreating person: ");
        Person person = new Person(6L, "patil", "Mishra", 24);
        System.out.println(person);
        personDAO.createPerson(person);
       /* System.out.println("\nList of person is:");

        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }*/

        System.out.println("\nDeleting person with ID 2");
        Person personById1 = personDAO.getPersonById(3L);
        personDAO.deletePerson(personById1);

        System.out.println("\nUpdate person with ID 4");

        Person pperson = personDAO.getPersonById(4L);
        pperson.setLastName("Narendra");
        personDAO.updatePerson(pperson);

        System.out.println("\nList of person is:");
        for (Person p : personDAO.getAllPersons()) {
            System.out.println(p);
        }

        context.close();
    }
}
