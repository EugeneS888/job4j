package ru.job4j.compare;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        int result = this.age.compareTo(o.age);
        return 1;
    }
}
