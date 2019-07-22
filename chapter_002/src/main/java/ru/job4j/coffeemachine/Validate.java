package ru.job4j.coffeemachine;

import ru.job4j.coffeemachine.MenuOutException;

import java.util.ArrayList;
import java.util.Arrays;

public class Validate {
    private int[] listInput = new int[]{50, 100};
    private int[] trifle = new int[]{1, 2, 5, 10};
    private int coffeePrice = 35;
    private int banknote = 100;

    public int getBanknote() {
        return this.banknote;
    }

    /*public int[] getTrifleList() {
        return this.trifle;
    }*/

    public int[] trifleCalculation() {
        int[] res = new int[15];
        int[] result = new int[]{0};
        int trifleSum = this.getBanknote() - this.coffeePrice;
        int count = 0;
        if (trifleSum > 0) {
            for (int i = trifle.length - 1; i >= 0; i--) {
                if (trifleSum % trifle[i] > 0) {
                    int maxIteration = (int) Math.floor((double) trifleSum / (double) trifle[i]);
                    for (int j = 0; j < maxIteration * trifle[i]; j = j + trifle[i]) {
                        res[count] = trifle[i];
                        trifleSum = trifleSum - trifle[i];
                        count++;
                    }
                } else {
                    res[count] = trifle[i];
                    break;
                }
            }
            result = new int[count + 1];
            System.arraycopy(res, 0, result, 0, count + 1);
        }
        return result;
    }

    public String getMessage(String msg) {
        String str = "( ";
        int i = 1;
        for (int list : listInput) {
            str = str.concat(String.valueOf(list));
            if (i != listInput.length) {
                str = str.concat(", ");
            }
            i++;
        }
        str = str.concat(" ):");

        String res = new StringBuilder()
                .append(msg)
                .append(str)
                .toString();
        return res;
    }

    public boolean changeRange(int userInput, int[] listInput) {
        boolean res = false;
        for (int list : listInput) {
            if (list == userInput) {
                res = true;
                break;
            }
        }
        if (!res) {
            throw new MenuOutException("");
        }
        return res;
    }

    public boolean isTrue(String inp) {
        boolean valid = false;
        try {
            valid = this.changeRange(Integer.valueOf(inp), listInput);
            if (valid) {
                this.banknote = Integer.valueOf(inp);
            }
        } catch (MenuOutException moe) {
            System.out.println(this.getMessage("Необходимо ввести купюру правильного номинала - "));
        } catch (NumberFormatException nfe) {
            System.out.println(this.getMessage("Необходимо ввести корректное значение - "));
        }
        return valid;
    }
}
