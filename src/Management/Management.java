package Management;

import User.AccountManager;
import User.User;
import User.Account;
import User.Individual;
import User.Enterprise;

public class Management {
    private AccountManager accountManager;

    public Management() {
        accountManager = new AccountManager();
    }

    public void displayMenu() {
        System.out.println("###########################");
        System.out.println("Policy Management System");
        System.out.println("1 - Add User (Individual or Enterprise)");
        System.out.println("2 - Login");
        System.out.println("3 - Show List Accounts");
        System.out.println("4 - Exit");
        System.out.println("############################");
        System.out.print("Choice: ");
    }

    public void addUser(String userType, String name, String username, String email, String password, String job, int age, String companyName) {
        User user = new User(name, username, email, password, job, age);
        if(userType.equalsIgnoreCase("I")) {
            Account account = new Individual(user);
            accountManager.addAccount(account);
            System.out.println("User added succesfully");
        } else if (userType.equalsIgnoreCase("E")) {
            Account account = new Enterprise(user, companyName);
            accountManager.addAccount(account);
            System.out.println("User added succesfully");
        } else {
            System.out.println("Invalid user type! Please try again.");
        }
    }

    public Account login(String email, String password) {
        Account account = accountManager.login(email, password);
        if(account != null) {
            account.showUserInfo();
        }
        return account;
    }

    public void afterLogin() {
        System.out.println("########################");
        System.out.println("1 - Add Addresses");
        System.out.println("2 - Add Insurance");
        System.out.println("3 - Show User Info");
        System.out.println("0 - Logout");
        System.out.println("#########################");
        System.out.print("Enter your choice: ");
    }

    public boolean isHaveAccounts() {
        return accountManager.getAccounts().isEmpty();
    }
}
