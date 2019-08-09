package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> res = profiles.stream().map(n -> n.getAddress()).distinct().collect(Collectors.toList());
        res.sort(
                new Comparator<Address>() {
                    public int compare(Address o1, Address o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                }
        );
        return res;

    }
}
