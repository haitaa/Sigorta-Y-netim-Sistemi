package User;

import Addresses.Address;
import Insurance.Insurance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.lang.Enum;
import java.util.Scanner;

public abstract class Account implements Comparable<Account>{
    Scanner input = new Scanner(System.in);

    protected  AuthenticationStatus authenticationStatus;
    protected User user;
    protected ArrayList<Insurance> insurances;

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }

    public Account(User user) {
        this.user = user;
    }

    public void showUserInfo() {
        System.out.println("Full Name: " + this.getUser().getName() + " " + this.getUser().getSurname() + "\nEmail: " + this.getUser().getEmail() + "\nPassword: " + this.getUser().getPassword() + "\nJob: " + this.getUser().getJob() + "\nAge: " + this.getUser().getAge());
        System.out.println("Addresses:");
        if(this.getUser().getAddresses() != null) {
            for(Address address : this.getUser().getAddresses()) {
                System.out.println(address);
            }
        } else {
            System.out.println("- None");
        }
        if(this.getInsurances() != null) {
            System.out.println("Insurances:");
            for(Insurance insurance : this.getInsurances()) {
                System.out.println(insurance);
            }
        } else {
            System.out.println("- None");
        }
        //System.out.println("Last Enter: " + this.getUser().getLastEnter());
    }

    public abstract void addInsurance(Insurance insurance);

    public void login(String email, String password) throws InvalidAuthenticationException{
        if(email.equals(this.getUser().getEmail()) && password.equals(this.getUser().getPassword())) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Hatalı giriş yapıldı.");
        }
    }

    @Override
    public int compareTo(Account account) {
        return this.getUser().getEmail().compareTo(account.user.getEmail());
    }

    @Override
    public int hashCode() {
        return this.getUser().getEmail().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }

        if(!(object instanceof Account)) {
            return false;
        }

        Account other = (Account) object;
        return this.getUser().getEmail().equals(other.getUser().getEmail());
    }

    public void addAddress(Address address) {
        if(authenticationStatus == AuthenticationStatus.SUCCESS) {
            getUser().getAddresses().add(address);
        }
    }

    public void removeAddress(Address address) {
        if(authenticationStatus == AuthenticationStatus.SUCCESS) {
            getUser().getAddresses().add(address);
        }
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }



    public ArrayList<Insurance> getInsurances() {
        return this.insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
