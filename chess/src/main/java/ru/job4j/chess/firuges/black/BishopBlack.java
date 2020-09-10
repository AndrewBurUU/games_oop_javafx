package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - source.getX() - size + 1;
        int deltaY = source.getY() - dest.getY() -  size + 1;
        for (int index = 0; index < size; index++) {
            int x = index + deltaX + source.getX();
            int y = source.getY() - index - deltaY;
            steps[index] = Cell.findBy(x,y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.getX() - source.getX());
        int deltaY = Math.abs(dest.getY() - source.getY());
        return deltaX == deltaY;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
