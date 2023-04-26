package org.tictactoe.view;

import org.tictactoe.model.Cell;

import java.awt.Color;
import java.awt.Graphics2D;

public class OCellView extends CellView {
    public OCellView(int width, int height, Cell cell) {
        super(width, height, cell);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setStroke(new java.awt.BasicStroke(5));
        // draw an O or circle
        int width = getWidth();
        int height = getHeight();
        int x = getX() + width/4;
        int y = getY() + height/4;
        g.drawOval(x, y, width/2, height/2);
    }
}
