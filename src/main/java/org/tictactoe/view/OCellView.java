package org.tictactoe.view;

import org.tictactoe.model.Cell;

import java.awt.Graphics;

public class OCellView extends CellView {
    public OCellView(Cell cell) {
        super(cell);
    }

    @Override
    public void draw(Graphics g) {
        // draw an O or circle
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        g.drawOval(x, y, width, height);
    }
}
