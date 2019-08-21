package ru.job4j.sortdepartmens;

import java.util.*;

public class Sort {
    private List<String> list = new ArrayList<String>();

    //private String[] departments = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
    private String[] departments;
    
    public void setDepartments(String[] departments) {
        this.departments = departments;
    }

    Comparator<String> compareAscending = new Comparator<String>() {
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    public void sortAscending() {
        System.out.println("Сортировка по возрастанию");
        //list = Arrays.asList(this.departments);
        Collections.sort(list, compareAscending);
        for (String li : list) {
            System.out.println(li);
        }
    }

    public void sortDescending() {
        System.out.println("Сортировка по убыванию");
        //list = Arrays.asList(this.departments);
        list.sort(
                new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
        for (String li : list) {
            System.out.println(li);
        }
    }

    public void checkDepartments() {
        Set<String> deps = new HashSet<String>();
        for (String dep : departments) {
            String[] subStr = dep.split("\\\\");
            deps.add(subStr[0]);
            if (subStr.length == 2) {
                deps.add(subStr[0].concat("\\").concat(subStr[1]));
            }
            if (subStr.length == 3) {
                deps.add(subStr[0].concat("\\").concat(subStr[1]));
                deps.add(subStr[0].concat("\\").concat(subStr[1]).concat("\\").concat(subStr[2]));
            }
        }
        list.addAll(deps);
    }
}
