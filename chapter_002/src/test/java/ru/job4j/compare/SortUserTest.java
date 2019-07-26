package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenUnsortThenSortByAge() {
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
        String expect = "15-Николай, 19-Иван, 30-Сергей, ";

        for (User user : set) {
            result = result.concat(user.getAge() + "-" + user.getName() + ", ");
        }
        assertThat(result, is(expect));
    }

    @Test
    public void whenUnsortThenSortByNameLength() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setAge(30);
        user1.setName("Сергей");
        user2.setAge(15);
        user2.setName("Николай");
        user3.setAge(19);
        user3.setName("Иван");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser sortUser = new SortUser();
        List<User> res = sortUser.sortNameLength(list);
        String result = "";
        String expect = "19-Иван, 30-Сергей, 15-Николай, ";

        for (User user : res) {
            result = result.concat(user.getAge() + "-" + user.getName() + ", ");
        }
        assertThat(result, is(expect));
    }

    @Test
    public void whenUnsortThenSortByNameAndAge() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        user1.setAge(30);
        user1.setName("Сергей");
        user2.setAge(15);
        user2.setName("Борис");
        user3.setAge(19);
        user3.setName("Артур");
        user4.setAge(25);
        user4.setName("Сергей");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        SortUser sortUser = new SortUser();
        List<User> res = sortUser.sortByAllFields(list);
        String result = "";
        String expect = "19-Артур, 15-Борис, 25-Сергей, 30-Сергей, ";

        for (User user : res) {
            result = result.concat(user.getAge() + "-" + user.getName() + ", ");
        }
        assertThat(result, is(expect));
    }
}