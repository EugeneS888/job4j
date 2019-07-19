package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        super("Так нельзя ходить");
    }
}
