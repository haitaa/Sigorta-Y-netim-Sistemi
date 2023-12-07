import Addresses.Address;

import java.util.ArrayList;
import java.util.Date;

public abstract class Account {
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected String job;
    protected int age;
    protected ArrayList<Address> addresses;
    protected Date lastEnter;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getLastEnter() {
        return this.lastEnter;
    }

    public void setLastEnter(Date lastEnter) {
        this.lastEnter = lastEnter;
    }
}
