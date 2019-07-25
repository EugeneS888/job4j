package ru.job4j.hotels;

public class TInputs implements Input {
    private final String value;
    private int position;

    public TInputs(final String value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return null;
    }
}
