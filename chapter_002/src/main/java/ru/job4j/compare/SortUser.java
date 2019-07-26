package ru.job4j.compare;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Collections.sort(list);
        return new TreeSet<>(list);
        /*
        Set<User> set = new TreeSet<>();
        Collections.sort(list);
        for (User user : list) {
            set.add(user);
        }
        return set;
         */
    }
}
