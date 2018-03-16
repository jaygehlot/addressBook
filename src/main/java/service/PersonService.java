package service;

import model.Gender;
import model.Person;
import reader.ReadAddresses;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class PersonService {

    private ReadAddresses readAddresses;

    public PersonService(ReadAddresses readAddresses) {
        this.readAddresses = readAddresses;
    }

    public int getGenderCount(Gender gender) throws IOException, URISyntaxException {
        final Long genderCount = getAddressBook().stream()
                .filter(person -> person.getGender() == gender).count();

        return genderCount.intValue();
    }

    private List<Person> getAddressBook() {
        return readAddresses.getPeopleAddress();
    }
}
