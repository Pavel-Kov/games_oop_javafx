package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
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
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException("Impossible Move");
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int startX = position.getX();
        int startY = position.getY();
        int deltaX = Integer.compare(dest.getX(), position.getX());
        int deltaY = Integer.compare(dest.getY(), position.getY());
        for (int index = 0; index < size; index++) {
            startX += deltaX;
            startY += deltaY;
            steps[index] = Cell.findBy(startX, startY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell position, Cell dest) {
        return Math.abs(dest.getX() - position.getX()) == Math.abs(dest.getY() - position.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
