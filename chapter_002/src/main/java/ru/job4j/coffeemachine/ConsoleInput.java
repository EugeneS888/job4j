package ru.job4j.coffeemachine;

import ru.job4j.coffeemachine.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /*public boolean checkRange(int key, int[] range) {
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        if (!this.checkRange(key, range)) {
            throw new MenuOutException("Выход за пределы range");
        }
        return key;
    }*/
}