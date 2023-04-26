package org.tictactoe.view;

import org.tictactoe.model.Cell;

import java.awt.Graphics2D;

public class EmptyCellView extends CellView {
    public EmptyCellView(int width, int height, Cell cell) {
        super(width, height, cell);
    }

    @Override
    public void draw(Graphics2D g) {
        // draw nothing
    }
}
