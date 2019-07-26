package ru.job4j.compare;

import java.util.*;

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

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return Integer.valueOf(o1.getName().length()).compareTo(o2.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName()) == 0 ? o1.getAge().compareTo(o2.getAge()) : o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }
}
