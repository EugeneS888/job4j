package ru.job4j.chess.firuges.white;

import ru.job4j.chess.Chess;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Chess.isDiagonal(source, dest)) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            for (int i = 0; i < steps.length; i++) {
                if (source.x < dest.x) {
                    if (source.y < dest.y) {
                        steps[i] = Chess.getCellName(source.x + i + 1, source.y + i + 1);
                    } else if (source.y > dest.y) {
                        steps[i] = Chess.getCellName(source.x + i + 1, source.y - i - 1);
                    }
                } else if (source.x > dest.x) {
                    if (source.y < dest.y) {
                        steps[i] = Chess.getCellName(source.x - i - 1, source.y + i + 1);
                    } else if (source.y > dest.y) {
                        steps[i] = Chess.getCellName(source.x - i - 1, source.y - i - 1);
                    }
                }
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean res = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            res = true;
        }
        return res;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
