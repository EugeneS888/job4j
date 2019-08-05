package ru.job4j.banks;

import java.util.*;

public class Bank {
    //List<User> users = new ArrayList<>();
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    public User getUserFromPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> us : this.userAccounts.entrySet()) {
            if (us.getKey().getPassport().equals(passport)) {
                user = us.getKey();
                break;
            }
        }
        return user;
    }

    public void addAccountToUser(String passport, Account account) {
        User user = this.getUserFromPassport(passport);
        if (user != null) {
            userAccounts.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.getUserFromPassport(passport);
        if (user != null) {
            userAccounts.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        User user = this.getUserFromPassport(passport);
        List<Account> list = new ArrayList<>();
        if (user != null) {
            list = userAccounts.get(user);
        }
        return list;
    }

    public Account getAccount(long rec, String pas) {
        Account account = null;
        List<Account> userAccounts = getUserAccounts(pas);
        for (Account userAccount : userAccounts) {
            if (rec == userAccount.getRequisites()) {
                account = userAccount;
            }
        }
        return account;
    }

    /*public Account getAccountFromRequisite(User user, long srcRequisite) {
        Account account = new Account();
        for (Account acc : userAccounts.get(user)) {
            if (acc.getRequisites() == srcRequisite) {
                account = acc;
                break;
            }
        }
        return account;
    }*/
    public boolean transferMoney(String srcPassport, long srcRequisite, String destPassport, long dstRequisite, double amount) {
        boolean res = false;
        Account account = getAccount(srcRequisite, srcPassport);
        Account account1 = getAccount(dstRequisite, destPassport);
        if (account != null && account1 != null) {
            if (account.getValue() >= amount) {
                account.setValue(account.getValue() - amount);
                account1.setValue(account1.getValue() + amount);
            }
            res = true;
        }

        return res;
    }
    /*public boolean transferMoney(String srcPassport, long srcRequisite, String destPassport, long dstRequisite, double amount) {
        boolean res = false;
        User user1 = this.getUserFromPassport(srcPassport);
        User user2 = this.getUserFromPassport(destPassport);
        if (user1 != null && user2 != null) {
            Account acc1 = this.getAccountFromRequisite(user1, srcRequisite);
            Account acc2 = this.getAccountFromRequisite(user2, dstRequisite);
            if (userAccounts.get(user1).contains(acc1) && userAccounts.get(user2).contains(acc2)) {
                if (acc1.getValue() >= amount) {
                    acc1.setValue(acc1.getValue() - amount);
                    acc2.setValue(acc2.getValue() + amount);
                    res = true;
                }
            }
        }
        return res;
    }*/


}
