package org.tictactoe.view;

import org.tictactoe.model.Cell;

import java.awt.Graphics2D;

public class XCellView extends CellView {

    public XCellView(int width, int height, Cell cell) {
        super(width, height, cell);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(java.awt.Color.RED);
        g.setStroke(new java.awt.BasicStroke(5));
        // draw an X
        int width = getWidth();
        int height = getHeight();
        int x = getX() + width/4;
        int y = getY() + height/4;
        g.drawLine(x, y, x + width/2, y + height/2);
        g.drawLine(x + width/2, y, x, y + height/2);
    }
}
