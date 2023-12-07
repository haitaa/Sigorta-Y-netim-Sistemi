package User;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public Account login(String email, String password) {
        for(Account account : this.accounts) {
            try {
                account.login(email, password);
                if(account.authenticationStatus == Account.AuthenticationStatus.SUCCESS) {
                    return account;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public TreeSet<Account> getAccounts() {
        return this.accounts;
    }

}
