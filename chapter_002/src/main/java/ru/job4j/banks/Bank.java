package ru.job4j.banks;

import java.util.*;

public class Bank {
    //List<User> users = new ArrayList<>();
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        this.userAccounts.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    public User getUserFromPassport(String passport) {
        User user = new User();
        for (Map.Entry<User, List<Account>> us : this.userAccounts.entrySet()) {
            if (us.getKey().getPassport().equals(passport)) {
                user = us.getKey();
                break;
            }
        }
        return user;
    }

    public Account getAccountFromRequisite(User user, long srcRequisite) {
        Account account = new Account();
        for (Account acc : userAccounts.get(user)) {
            if (acc.getRequisites() == srcRequisite) {
                account = acc;
                break;
            }
        }
        return account;
    }

    public void addAccountToUser(String passport, Account account) {
        userAccounts.get(this.getUserFromPassport(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        userAccounts.get(this.getUserFromPassport(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return userAccounts.get(this.getUserFromPassport(passport));
    }

    public boolean transferMoney(String srcPassport, long srcRequisite, String destPassport, long dstRequisite, double amount) {
        boolean res = false;
        User user1 = this.getUserFromPassport(srcPassport);
        User user2 = this.getUserFromPassport(destPassport);
        Account acc1 = this.getAccountFromRequisite(user1, srcRequisite);
        Account acc2 = this.getAccountFromRequisite(user2, dstRequisite);
        if (userAccounts.get(user1).contains(acc1) && userAccounts.get(user2).contains(acc2)) {
            if (acc1.getValue() >= amount) {
                acc1.setValue(acc1.getValue() - amount);
                acc2.setValue(acc2.getValue() + amount);
                res = true;
            }
        }
        return res;
    }


}
