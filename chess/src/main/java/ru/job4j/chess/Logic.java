package ru.job4j.chess;

import javafx.scene.control.Alert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    for (int i = 0; i < this.figures.length; i++) {
                        for (int j = 0; j < steps.length; j++) {
                            if (steps[j].equals(this.figures[i].position())) {
                                throw new OccupiedWayException("На пути занятая клетка");
                            }
                        }
                    }
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            } catch (OccupiedWayException owe) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("На пути занятая клетка");
                alert.showAndWait();
            } catch (ImpossibleMoveException ime) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Так нельзя ходить");
                alert.showAndWait();
            } catch (FigureNotFoundException fnfe) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Фигура не найдена");
                alert.showAndWait();
            }

        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
