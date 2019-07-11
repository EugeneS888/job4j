package ru.job4j.tracker;

public class ValidateInput implements Input {
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
                value = this.input.ask(question, range);
                boolean exist = false;
                for (int item : range) {
                    if (item == value) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    throw new MenuOutException("Выход за пределы range");
                }
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
