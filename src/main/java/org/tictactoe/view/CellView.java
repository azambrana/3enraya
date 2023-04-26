package org.tictactoe.view;

import org.tictactoe.model.Cell;

import javax.swing.JComponent;
import java.awt.Graphics;

public abstract class CellView extends JComponent implements Drawable {
    private Cell cell;

    public CellView(Cell cell) {
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

    @Override
    public void draw(Graphics g) {
        // ToDo: Draw the cell
    }
}
