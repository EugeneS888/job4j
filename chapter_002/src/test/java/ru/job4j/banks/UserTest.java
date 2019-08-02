package ru.job4j.banks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void whenBankOperationsThenGetData() {
        User user1 = new User("Иван", "78787787");
        User user2 = new User("Сергей", "16548449");
        User user3 = new User("Алекс", "68488894");
        Account acc1 = new Account(10000d, 111L);
        Account acc2 = new Account(15000d, 222L);
        Account acc3 = new Account(30000d, 333L);
        Account acc4 = new Account(55000d, 444L);
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        bank.deleteUser(user2);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user3.getPassport(), acc4);
        bank.addAccountToUser(user1.getPassport(), acc2);
        bank.addAccountToUser(user1.getPassport(), acc3);
        bank.deleteAccountFromUser(user1.getPassport(), acc2);
        StringBuilder result = new StringBuilder();
        String expect = new StringBuilder()
                .append("Иван - сумма: 10000.0 ; счет: 111")
                .append(System.lineSeparator())
                .append("Иван - сумма: 25000.0 ; счет: 333")
                .append(System.lineSeparator())
                .append("Алекс - сумма: 60000.0 ; счет: 444")
                .append(System.lineSeparator())
                .toString();
        //System.out.println(bank.getUserFromPassport(user2.getPassport()).getName());
        bank.transferMoney(user1.getPassport(), acc3.getRequisites(), user3.getPassport(), acc4.getRequisites(), 5000D);
        List<Account> user1Acc = bank.getUserAccounts(user1.getPassport());
        for (Account li : user1Acc) {
            result.append(String.format("%s - сумма: %s ; счет: %s", user1.getName(), li.getValue(), li.getRequisites())).append(System.lineSeparator());
        }
        List<Account> user3Acc = bank.getUserAccounts(user3.getPassport());
        for (Account li : user3Acc) {
            result.append(String.format("%s - сумма: %s ; счет: %s", user3.getName(), li.getValue(), li.getRequisites())).append(System.lineSeparator());
        }
        System.out.println(result);
        assertThat(result.toString(), is(expect));
    }
}