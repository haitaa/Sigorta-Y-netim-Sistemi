import Addresses.Address;
import Addresses.BusinessAddress;
import Addresses.HomeAddress;
import Insurance.CarInsurance;
import Insurance.HealthInsurance;
import Insurance.ResidenceInsurance;
import Insurance.TravelInsurance;
import Management.Management;
import User.User;
import java.util.Scanner;
import User.Account;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Management management = new Management();

        int choice = -1;
        while(choice != 0) {
            management.displayMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter user type (Individual or Enterprise) (I/R): ");
                    String userType = input.next();
                    System.out.print("Enter user name: ");
                    String name = input.next();
                    System.out.print("Enter user surname: ");
                    String surname = input.next();
                    System.out.print("Enter user email: ");
                    String email = input.next();
                    System.out.print("Enter user password: ");
                    String password = input.next();
                    System.out.print("Type again your password: ");
                    String correctPassword = input.next();
                    if(!password.equals(correctPassword)) {
                        System.out.println("Wrong password! Please try again.");
                        break;
                    }
                    System.out.print("Enter user's job: ");
                    String job = input.next();
                    System.out.print("Enter user age: ");
                    int age = input.nextInt();
                    String company = null;
                    if(userType.equalsIgnoreCase("E")) {
                        System.out.print("Enter user company name: ");
                        company = input.next();
                    }
                    management.addUser(userType, name, surname, email, password, job, age, company);
                    break;
                case 2:
                    if(management.isHaveAccounts()) {
                        System.out.println("There's no accounts in database.");
                        System.out.println("Please add one to continue the proccess.");
                        break;
                    }
                    System.out.print("Enter email: ");
                    email = input.next();
                    System.out.print("Enter password: ");
                    password = input.next();
                    Account account = management.login(email, password);
                    if(account == null){
                        System.out.println("Account not found!");
                        break;
                    } else {
                        System.out.println("Login succesfull!");
                        int option = -1;
                        while(option != 0) {
                            management.afterLogin();
                            option = input.nextInt();
                            switch(option) {
                                case 0:
                                    account = null;
                                    System.out.println("Logout succesfully.");
                                    System.exit(0);
                                    break;
                                case 1:
                                    System.out.println("1 - Home address");
                                    System.out.println("2 - Business address");
                                    System.out.print("Choice: ");
                                    choice = input.nextInt();
                                    System.out.print("Enter your address: ");
                                    String address = input.next();
                                    System.out.print("Enter your street: ");
                                    String street = input.next();
                                    System.out.print("Enter your city: ");
                                    String city = input.next();
                                    System.out.print("Enter your country: ");
                                    String country = input.next();
                                    System.out.print("Enter your postal code: ");
                                    String postalCode = input.next();
                                    if(choice == 1) {
                                        HomeAddress homeAddress = new HomeAddress(address, street, city, country, postalCode);
                                        account.addAddress(homeAddress);
                                    } else if(choice == 2) {
                                        System.out.print("Enter your company name: ");
                                        String companyName = input.next();
                                        BusinessAddress businessAddress = new BusinessAddress(address, street, city, country, postalCode, companyName);
                                        account.addAddress(businessAddress);
                                    } else {
                                        System.out.println("Please type valid option.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("1 - Car Insurance");
                                    System.out.println("2 - Health Insurance");
                                    System.out.println("3 - Residence Insurance");
                                    System.out.println("4 - Travel Insurance");
                                    System.out.print("Enter your choice: ");
                                    choice = input.nextInt();
                                    if(choice > 0 && choice < 5) {
                                        switch (choice) {
                                            case 1:
                                                System.out.print("Enter your cars name: ");
                                                String carName = input.next();
                                                System.out.print("Enter your cars price: ");
                                                double price = input.nextDouble();
                                                CarInsurance carInsurance = new CarInsurance(carName, price);
                                                account.addInsurance(carInsurance);
                                                break;
                                            case 2:
                                                System.out.print("Enter your health condition: ");
                                                String healthCondition = input.next();
                                                System.out.print("Enter coverage limit: ");
                                                double coverage = input.nextDouble();
                                                HealthInsurance healthInsurance = new HealthInsurance(healthCondition, coverage);
                                                account.addInsurance(healthInsurance);
                                                break;
                                            case 3:
                                                System.out.print("Enter building name: ");
                                                String buildingName = input.next();
                                                System.out.print("Enter content value: ");
                                                double contentValue = input.nextDouble();
                                                ResidenceInsurance residenceInsurance = new ResidenceInsurance(buildingName, contentValue);
                                                account.addInsurance(residenceInsurance);
                                                break;
                                            case 4:
                                                System.out.print("Enter country: ");
                                                String countryName = input.next();
                                                System.out.print("Enter expenses: ");
                                                double travelExpenses = input.nextDouble();
                                                TravelInsurance travelInsurance = new TravelInsurance(countryName, travelExpenses);
                                                account.addInsurance(travelInsurance);
                                                break;
                                        }
                                    } else {
                                        System.out.println("Invalid choice!");
                                    }
                                    break;
                                case 3:
                                    account.showUserInfo();
                                    break;
                                default:
                                    System.out.println("Please enter valid option!");
                                    System.exit(0);
                                    break;
                            }
                        }
                    }
            }
        }
    }
}