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
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if ((source.x - 1 == dest.x && source.y - 1 == dest.y)
                || (source.x == dest.x && source.y - 1 == dest.y)
                || (source.x + 1 == dest.x && source.y - 1 == dest.y)
                || (source.x + 1 == dest.x && source.y == dest.y)
                || (source.x + 1 == dest.x && source.y + 1 == dest.y)
                || (source.x == dest.x && source.y + 1 == dest.y)
                || (source.x - 1 == dest.x && source.y + 1 == dest.y)
                || (source.x - 1 == dest.x && source.y == dest.y)
        ) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException();
        }
        return steps;
        /*if (Chess.isLine(source, dest) && (Math.abs(source.x - dest.x) == 1 || Math.abs(source.y - dest.y) == 1)) {
            steps = new Cell[1];
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
        } else if (Chess.isDiagonal(source, dest) && (Math.abs(source.x - dest.x) == 1 || Math.abs(source.y - dest.y) == 1)) {
            steps = new Cell[1];
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
        return steps;*/
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
