import model.Gender;
import reader.ReadAddresses;
import service.PersonService;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainApp {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ReadAddresses readAddresses = new ReadAddresses("AddressBook");

        PersonService personAgeService = new PersonService(readAddresses);

        //1st problem
        System.out.println("Gender count for Male is: " + personAgeService.getGenderCount(Gender.MALE));

        /* 2nd problem */
        System.out.println("Eldest person in address list is " + personAgeService.fetchEldestPerson().getName());
    }

}
