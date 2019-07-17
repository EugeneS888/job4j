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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
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
            throw new ImpossibleMoveException("Невозможно передвинуть");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
