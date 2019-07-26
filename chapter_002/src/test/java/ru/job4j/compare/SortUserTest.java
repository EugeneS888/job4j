package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void when5ElementsThenRange() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setAge(19);
        user1.setName("Иван");
        user2.setAge(30);
        user2.setName("Сергей");
        user3.setAge(15);
        user3.setName("Николай");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser sortUser = new SortUser();
        Set<User> set = sortUser.sort(list);
        String result = "";
        String expect = "19-Иван, 30-Сергей, 15-Николай, ";

        for (User user : set) {
            result = result.concat(user.getAge() + "-" + user.getName() + ", ");
        }
        assertThat(result, is(expect));
    }
}