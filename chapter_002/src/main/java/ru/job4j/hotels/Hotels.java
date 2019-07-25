package ru.job4j.hotels;

import java.util.Map;

public class Hotels {
    private final Input input;

    public Hotels(Input input) {
        this.input = input;
    }

    public void init() {
        Validate validateInput = new Validate();
        String question = "Количество отелей (кратно 5):";
        boolean res = false;
        do {
            res = validateInput.isTrueNumHotels(input.ask(question));
        } while (!res);

        question = "Введите последовательность из n различных целых положительных чисел a1, a2, ..." +
                ", an (1 ≤ ai ≤ 100), где ai равно рейтингу i-го отеля:";
        res = false;
        do {
            res = validateInput.isTrueRate(input.ask(question));
        } while (!res);


        System.out.println("Звезды отелей:");
        for (Map.Entry<Integer, Integer> entry : validateInput.getStars().entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        new Hotels(new ConsoleInput()).init();
    }
}
