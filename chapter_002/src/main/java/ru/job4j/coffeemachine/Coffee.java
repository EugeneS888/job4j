package ru.job4j.coffeemachine;

import ru.job4j.coffeemachine.ConsoleInput;

public class Coffee {
    private final Input input;

    public Coffee(Input input) {
        this.input = input;
    }

    public void init() {
        Validate validateInput = new Validate();
        String question = validateInput.getMessage("Введите номинал купюры - ");
        boolean res = false;
        do {
            res = validateInput.isTrue(input.ask(question));
        } while (!res);
        System.out.println("Сдача:");
        for (int trifle : validateInput.trifleCalculation()) {
            System.out.println(trifle);
        }
    }

    public static void main(String[] args) {
        new Coffee(new ConsoleInput()).init();
    }
}
