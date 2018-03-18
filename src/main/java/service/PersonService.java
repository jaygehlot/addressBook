package service;

import model.Gender;
import model.Person;
import reader.ReadAddresses;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PersonService {

    private ReadAddresses readAddresses;

    public PersonService(ReadAddresses readAddresses) {
        this.readAddresses = readAddresses;
    }

    /**
     * Fetching the eldest person will either return a List of Persons
     * that share the same birth date, or the eldest person in the list
     * or an empty list
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public List<Person> fetchEldestPerson() throws IOException, URISyntaxException {

        List<Person> eldestFirstSortedList = getAddressBook()
                .stream()
                .sorted(Comparator.comparing(Person::getLocalDate))
                .filter(person -> person.getLocalDate().isEqual(person.getLocalDate()))
                .collect(toList());

        return eldestFirstSortedList.stream().
                filter(person -> person.getLocalDate().equals(eldestFirstSortedList.get(0).getLocalDate()))
                .collect(toList());
    }

    /**
     * The number of Males or Females will be returned depending on what is requested.
     * Zero returned if the address book is empty
     * @param gender Male or Female, the type of Gender requested to be counted
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public int fetchGenderCount(Gender gender) throws IOException, URISyntaxException {
        final Long genderCount = getAddressBook().stream()
                .filter(person -> person.getGender() == gender).count();

        return genderCount.intValue();
    }

    private List<Person> getAddressBook() {
        return readAddresses.getPeopleAddress();
    }
}
