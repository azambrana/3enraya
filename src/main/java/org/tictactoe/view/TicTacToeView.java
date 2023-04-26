package org.tictactoe.view;

import org.tictactoe.model.TicTacToeModel;

import javax.swing.JPanel;
import java.awt.Graphics;

public class TicTacToeView extends JPanel implements Drawable {
    private static final int CELL_WIDTH = 100;
    private static final int CELL_HEIGHT = 100;
    private CellView[][] cellViews;

    private TicTacToeModel model;

    public TicTacToeView(int rows, int columns, TicTacToeModel model) {
        cellViews = new CellView[rows][columns];
        this.setModel(model);
        initializeCells(rows, columns);
        this.setSize(CELL_WIDTH * columns, CELL_HEIGHT * rows);
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(true);
    }

    private void initializeCells(int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns ; column++) {
                CellView cellView = new EmptyCellView(this.model.getCell(row, column));
                cellView.setBounds(column * CELL_WIDTH, row * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                cellViews[row][column] = cellView;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        drawLines(g);
        drawCells(g);
    }

    private void drawCells(Graphics g) {
        for (CellView[] cellViewRow : cellViews) {
            for (CellView cellView : cellViewRow) {
                cellView.draw(g);
            }
        }
    }

    private void drawLines(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        for (int i = 1; i < model.getRows(); i++) {
            g.drawLine(0, i * CELL_HEIGHT, width, i * CELL_HEIGHT);
        }
        for (int i = 1; i < model.getColumns(); i++) {
            g.drawLine(i * CELL_WIDTH, 0, i * CELL_WIDTH, height);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void update() {
        repaint();
    }

    public int getCellWidth() {
        return CELL_WIDTH;
    }

    public int getCellHeight() {
        return CELL_HEIGHT;
    }

    public void setModel(TicTacToeModel model) {
        this.model = model;
    }

    public void updateCellView(int row, int column, CellView cellView) {
        cellViews[row][column] = cellView;
        cellViews[row][column].repaint();
    }
}
