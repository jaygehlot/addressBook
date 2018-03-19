package service;

import model.Person;
import org.junit.Test;
import reader.ReadAddresses;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static model.Gender.FEMALE;
import static model.Gender.MALE;
import static org.junit.Assert.assertEquals;

public class PersonServiceTest {

    @Test
    public void genderCountReturnsZeroWhenAddressBookIsEmpty() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("EmptyAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.fetchGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsZeroWhenNoFemalesInAddressBook() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MaleAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.fetchGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsFiveWhen5MaleExistInAddressBook() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MixedGenderAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(5, personService.fetchGenderCount(MALE));
    }

    @Test
    public void eldestPersonInAddressBookIsReturnedWithOneAsOldestExisting() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MixedGenderAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals("Richard Espley", personService.fetchEldestPerson().get(0).getName());
    }


    @Test
    public void eldestPeopleInAddressInAddressBookAreReturnedMultipleEldest() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("MultipleEldestAddressBook");
        PersonService personService = new PersonService(readAddresses);

        List<String> expectedNames = Arrays.asList("Romelu Lukaku", "Mohan Gehlot", "Richard Espley");
        List<String> actualdNames = personService.fetchEldestPerson()
                                        .stream()
                                        .map(Person::getName)
                                        .collect(toList());

        assertEquals(expectedNames, actualdNames);
    }

    @Test
    public void noEldestPersonReturnedFromEmptyAddressBook() throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("EmptyAddressBook");
        PersonService personService = new PersonService(readAddresses);

        List<String> actualdNames = personService.fetchEldestPerson()
                                        .stream()
                                        .map(Person::getName)
                                        .collect(toList());

        assertEquals(emptyList(), actualdNames);
    }
}

