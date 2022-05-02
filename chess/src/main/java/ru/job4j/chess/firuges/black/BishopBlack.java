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
        if(!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = this.position.getX() > dest.getX() ? -1 : 1;
        int deltaY = this.position.getY() > dest.getY() ? 1 : -1;
        for (int i = 0; i < size; i++) {
            int x = this.position.getX() + (i + 1) * deltaX;
            int y = this.position.getY() + (i + 1) * deltaY;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
