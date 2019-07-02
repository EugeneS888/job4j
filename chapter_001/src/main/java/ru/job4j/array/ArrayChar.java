package ru.job4j.array;

/**
 * Обертка над строкой.
 *
 * @author Eugene
 */
public class ArrayChar {

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            // проверить. что массив data имеет первые элементы одинаковые с value
            if (wrd[i] != pref[i]) {
                result = false;
            }
        }
        return result;
    }
}