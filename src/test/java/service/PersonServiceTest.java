package service;

import org.junit.Test;
import reader.ReadAddresses;

import static model.Gender.FEMALE;
import static model.Gender.MALE;
import static org.junit.Assert.*;

public class PersonServiceTest {

    @Test
    public void genderCountReturnsZeroWhenAddressBookIsEmpty()  {
        ReadAddresses readAddresses = new ReadAddresses("EmptyAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.getGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsZeroWhenNoFemalesInAddressBook() {
        ReadAddresses readAddresses = new ReadAddresses("MaleAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(0, personService.getGenderCount(FEMALE));
    }

    @Test
    public void genderCountReturnsFiveWhen5MaleExistInAddressBook() {
        ReadAddresses readAddresses = new ReadAddresses("MaleAddressBook");
        PersonService personService = new PersonService(readAddresses);

        assertEquals(5, personService.getGenderCount(MALE));
    }

}