package ru.job4j.chess.firuges;

public interface Figure {
    Cell position();

    /**
     *
     * @param source Исходное положение
     * @param dest Конечное положение
     * @return
     */
    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
