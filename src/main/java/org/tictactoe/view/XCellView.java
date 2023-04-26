package org.tictactoe.view;

import org.tictactoe.model.Cell;

import java.awt.Graphics;

public class XCellView extends CellView {
    public XCellView(Cell cell) {
        super(cell);
    }

    @Override
    public void draw(Graphics g) {
        // draw an X
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        g.drawLine(x, y, x + width, y + height);
        g.drawLine(x + width, y, x, y + height);
    }
}
