package ru.job4j.banks;

import java.util.*;

public class Bank {
    List<User> users = new ArrayList<>();
    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User us : users) {
            if (us.getPassport().equals(passport)) {
                us.usAcc.add(account);
                userAccounts.putIfAbsent(us, us.usAcc);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User us : users) {
            if (us.getPassport().equals(passport)) {
                us.usAcc.remove(account);
                userAccounts.putIfAbsent(us, us.usAcc);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (User us : users) {
            if (us.getPassport().equals(passport)) {
                list = userAccounts.get(us);
            }
        }
        return list;
    }

    /**
     * Перечисляем из с одного счета пользователя на другой счет любого пользователя.
     *
     * @param srcPassport  исходный паспорт
     * @param srcRequisite исходные реквизиты
     * @param destPassport целевой паспорт
     * @param dstRequisite целевые реквизиты
     * @param amount       сумма перевода
     * @return boolean
     */
    public boolean transferMoney(String srcPassport, long srcRequisite, String destPassport, long dstRequisite, double amount) {
        boolean res = false;
        int indexSrcUser = this.indexUser(srcPassport);
        int indexDstUser = this.indexUser(destPassport);
        if (indexSrcUser > 0) {
            if (indexDstUser > 0) {
                int indexSrcAccount = this.indexUserRequisite(indexSrcUser - 1, srcRequisite);
                int indexDstAccount = this.indexUserRequisite(indexDstUser - 1, dstRequisite);
                if (indexSrcAccount > 0 && indexDstAccount > 0) {
                    //System.out.println((indexSrcUser - 1) + "," + (indexDstUser - 1) + "," + (indexSrcAccount - 1) + "," + (indexDstAccount - 1));
                    users.get(indexSrcUser - 1).usAcc.set(indexSrcAccount - 1,
                            new Account(
                                    users.get(indexSrcUser - 1).usAcc.get(indexSrcAccount - 1).getValue() - amount,
                                    users.get(indexSrcUser - 1).usAcc.get(indexSrcAccount - 1).getRequisites()
                            )
                    );
                    users.get(indexDstUser - 1).usAcc.set(indexDstAccount - 1,
                            new Account(
                                    users.get(indexDstUser - 1).usAcc.get(indexDstAccount - 1).getValue() + amount,
                                    users.get(indexDstUser - 1).usAcc.get(indexDstAccount - 1).getRequisites()
                            )
                    );
                }
            }
        }
        return res;
    }

    /**
     * Возвращает индекс пользователя в списке пользователец
     *
     * @param srcPassport номер паспорта
     * @return индекс пользователя+1
     */
    public int indexUser(String srcPassport) {
        int res = 0;
        for (User us : users) {
            if (us.getPassport().equals(srcPassport)) {
                res = users.indexOf(us) + 1;
            }
        }
        return res;
    }

    /**
     * Возвращает индекс счета в списке счетов пользователя
     *
     * @param indexUser    индекс пользователя
     * @param srcRequisite реквизиты счета
     * @return индекс счета +1
     */
    public int indexUserRequisite(int indexUser, long srcRequisite) {
        int res = 0;

        for (Account acc : userAccounts.get(users.get(indexUser))) {
            if (acc.getRequisites() == srcRequisite) {
                res = userAccounts.get(users.get(indexUser)).indexOf(acc) + 1;
                break;
            }
        }
        return res;
    }
}
