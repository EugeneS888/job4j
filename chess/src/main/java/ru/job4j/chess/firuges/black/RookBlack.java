package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Chess;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Chess.isLine(source, dest)) {
            int numSteps = Math.max(Math.abs(dest.x - source.x), Math.abs(dest.y - source.y));
            steps = new Cell[numSteps];
            for (int i = 0; i < steps.length; i++) {
                if (source.x != dest.x) {
                    if (source.x < dest.x) {
                        steps[i] = Chess.getCellName(source.x + i + 1, source.y);
                    } else {
                        steps[i] = Chess.getCellName(source.x - i - 1, source.y);
                    }
                } else if (source.y != dest.y) {
                    if (source.y < dest.y) {
                        steps[i] = Chess.getCellName(source.x, source.y + i + 1);
                    } else {
                        steps[i] = Chess.getCellName(source.x, source.y - i - 1);
                    }
                }
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
