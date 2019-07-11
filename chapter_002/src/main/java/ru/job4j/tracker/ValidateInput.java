package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Необходимо выбрать значение из диапазона меню");
            } catch (NumberFormatException nfe) {
                //nfe.printStackTrace();
                System.out.println("Необходимо ввести корректное значение!");
            }
        } while (invalid);
        return value;
    }
}
