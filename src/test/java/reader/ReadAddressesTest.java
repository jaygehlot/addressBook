package reader;

import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static model.Gender.MALE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReadAddressesTest {

    private ReadAddresses readAddresses;
    private ReadAddresses emptyAddress;

    @Before
    public void setup() {
        readAddresses = new ReadAddresses("TestAddressBook");
        emptyAddress = new ReadAddresses("EmptyAddressBook");
    }

    @Test
    public void readPeopleFromAddressBook() {

        List<Person> expectedListOfPeople = Arrays.asList(new Person("Jose Mourinho", MALE, LocalDate.of(1970, MARCH, 16)),
                new Person("Paul Pogba", MALE, LocalDate.of(1991, JANUARY, 15)));

        List<Person> actualListOfPeople = readAddresses.getPeopleAddress();

        assertThat(expectedListOfPeople, equalTo(actualListOfPeople));
    }

    @Test
    public void readEmptyAddressBook() {
        assertEquals(Collections.emptyList(), emptyAddress.getPeopleAddress());
    }
}
