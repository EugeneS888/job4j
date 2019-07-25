package ru.job4j.hotels;

import com.sun.javafx.collections.MappingChange;
import ru.job4j.hotels.MenuOutException;

import java.util.*;

public class Validate {
    private Map<Integer, Integer> numRate = new TreeMap<>();
    private Map<Integer, Integer> stars = new TreeMap<>();
    private int hotels;

    public Map<Integer, Integer> getStars() {
        return this.stars;
    }

    public boolean changeRange(int userInput) {
        boolean res = false;
        if (userInput % 5 == 0) res = true;
        if (!res) {
            throw new ru.job4j.hotels.MenuOutException("");
        }
        return res;
    }

    public boolean isTrueNumHotels(String inp) {
        boolean valid = false;
        try {
            valid = this.changeRange(Integer.valueOf(inp));
            if (valid) {
                this.hotels = Integer.valueOf(inp);
            }
        } catch (MenuOutException moe) {
            System.out.println("Количество отелей должно быть кратно 5:");
        } catch (NumberFormatException nfe) {
            System.out.println("Необходимо ввести число:");
        }
        return valid;
    }

    public boolean changeRates(String userInput) {
        boolean res = false;
        String strArr[] = userInput.split(" ");
        int min = 100;
        if (strArr.length == this.hotels) {
            for (int i = 0; i < strArr.length; i++) {
                Integer.valueOf(strArr[i]);
                if (Integer.parseInt(strArr[i]) < 1 || Integer.parseInt(strArr[i]) > 100)
                    throw new ru.job4j.hotels.RatesException("");
                min = Math.min(min, i + 1);
                this.numRate.put(Integer.parseInt(strArr[i]), i + 1);
            }
            int j = 1;
            int countStars = 1;
            for (Map.Entry<Integer, Integer> entry : numRate.entrySet()) {
                this.stars.put(entry.getValue(), countStars);
                if (j == hotels / 5) {
                    countStars++;
                    j = 0;
                }
                j++;
            }
            res = true;
        }
        if (!res) {
            throw new ru.job4j.hotels.RatesException("");
        }
        return res;
    }

    public boolean isTrueRate(String inp) {
        boolean valid = false;
        try {
            valid = this.changeRates(inp);
        } catch (RatesException re) {
            System.out.println("Введите " + this.hotels + " целых чисел, разделеных пробелом:");
        } catch (NumberFormatException nfe) {
            System.out.println("Необходимо ввести числа, разделеные пробелом:");
        }
        return valid;
    }
}