package service;

import model.Gender;
import reader.ReadAddresses;

public class PersonService {


    private ReadAddresses readAddresses;

    public PersonService(ReadAddresses readAddresses) {
        this.readAddresses = readAddresses;
    }

    public int getGenderCount(Gender female) {
        return 0;
    }
}
