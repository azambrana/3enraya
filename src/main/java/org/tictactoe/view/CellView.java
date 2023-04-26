package org.tictactoe.view;

import org.tictactoe.model.Cell;

public abstract class CellView implements Drawable {
    private Cell cell;
    private int width;
    private int height;

    public CellView(int width, int height, Cell cell) {
        this.width = width;
        this.height = height;
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public int getRow() {
        return cell.getRow();
    }

    public int getColumn() {
        return cell.getColumn();
    }

    public int getX() {
        return getColumn() * width;
    }

    public int getY() {
        return getRow() * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
