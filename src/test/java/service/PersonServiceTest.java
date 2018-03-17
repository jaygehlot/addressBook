package service;

import org.junit.Test;
import reader.ReadAddresses;

import java.io.IOException;
import java.net.URISyntaxException;

import static model.Gender.FEMALE;
import static model.Gender.MALE;
import static org.junit.Assert.*;

public class PersonServiceTest {

    @Test
    public void genderCountReturnsZeroWhenAddressBookIsEmpty() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("EmptyAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.getGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsZeroWhenNoFemalesInAddressBook() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MaleAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.getGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsFiveWhen5MaleExistInAddressBook() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MixedGenderAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(5, personService.getGenderCount(MALE));
    }

    @Test
    public void eldestPersonInAddressBookIsReturnedWithOneAsOldestExisting() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MixedGenderAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals("Richard Espley", personService.fetchEldestPerson().getName());
    }
}

//    @Test
//    public void eldestPersonInAddressInAddressBookIsReturnedMultipleEldest() {
//
//    }

