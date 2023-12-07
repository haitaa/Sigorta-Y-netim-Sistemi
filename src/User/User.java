import Addresses.Address;

import java.util.ArrayList;
import java.util.Date;

public class User extends Account{
    public User(String name, String surname, String email, String password, String job, int age, ArrayList<Address> addresses, Date lastEnter) {
        super.setName(name);
        super.setSurname(surname);
        super.setEmail(email);
        super.setPassword(password);
        super.setJob(job);
        super.setAge(age);
        super.setAddresses(addresses);
        super.setLastEnter(lastEnter);
    }
}
