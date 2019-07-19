package ru.job4j.chess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    private Logic logic = new Logic();
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void buildTeams() {
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C7));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E7));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        logic.add(new PawnWhite(Cell.A2));
        logic.add(new PawnWhite(Cell.B2));
        logic.add(new PawnWhite(Cell.C2));
        logic.add(new PawnWhite(Cell.D2));
        logic.add(new PawnWhite(Cell.E2));
        logic.add(new PawnWhite(Cell.F2));
        logic.add(new PawnWhite(Cell.G2));
        logic.add(new PawnWhite(Cell.H2));
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopWhite(Cell.C1));
        logic.add(new QueenWhite(Cell.D1));
        logic.add(new KingWhite(Cell.E1));
        logic.add(new BishopWhite(Cell.F1));
        logic.add(new KnightWhite(Cell.G1));
        logic.add(new RookWhite(Cell.H1));
    }

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenMovePawnThenGetExeptions() {
        this.buildTeams();
        logic.move(Cell.E2, Cell.E3);
        logic.move(Cell.E3, Cell.E4);
        logic.move(Cell.E4, Cell.E5);
        logic.move(Cell.E5, Cell.E6);
        try {
            logic.move(Cell.E7, Cell.E6);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E7, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenMoveBishopThenGetExeptions() {
        this.buildTeams();
        try {
            logic.move(Cell.C8, Cell.F5);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.C8, Cell.C7);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenMoveKnightThenGetExeptions() {
        this.buildTeams();
        try {
            logic.move(Cell.B8, Cell.D7);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.B8, Cell.D8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenMoveRookThenGetExeptions() {
        this.buildTeams();
        try {
            logic.move(Cell.H8, Cell.H4);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.H8, Cell.G7);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenMoveQueenThenGetExeptions() {
        this.buildTeams();
        try {
            logic.move(Cell.D8, Cell.G5);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.D8, Cell.C6);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenMoveKingThenGetExeptions() {
        this.buildTeams();
        try {
            logic.move(Cell.E8, Cell.E7);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E8, Cell.E6);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            logic.move(Cell.E5, Cell.F8);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("На пути занятая клетка")
                                .append(System.lineSeparator())
                                .append("Так нельзя ходить")
                                .append(System.lineSeparator())
                                .append("Здесь нет фигуры")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}