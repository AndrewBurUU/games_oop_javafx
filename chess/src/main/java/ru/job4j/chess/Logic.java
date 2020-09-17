package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

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
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = figures[index].way(source, dest);
        if (!isFree(steps)) {
            throw new OccupiedCellException();
        }
        figures[index] = figures[index].copy(dest);
    }

    private boolean isFree(Cell[] steps) throws OccupiedCellException {
        for (int index = 0; index < steps.length; index++) {
            if (findBy(steps[index]) >= 0 ) {
                throw new OccupiedCellException();
            }
/*
            for (int indexFigure = 0; indexFigure < figures.length; indexFigure++) {
                if (steps[index].compareTo(figures[indexFigure].position()) == 0) {
                    throw new OccupiedCellException();
                }
            }
 */
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) {
        int res = -1;
        for (int index = 0; index != figures.length; index++) {
            if (figures[index] != null && figures[index].position().equals(cell)) {
                res = index;
            }
        }
        return res;
    }
}
