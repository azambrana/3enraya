package org.tictactoe.controller;

import org.tictactoe.model.Cell;
import org.tictactoe.model.Symbol;
import org.tictactoe.model.TicTacToeModel;
import org.tictactoe.view.OCellView;
import org.tictactoe.view.TicTacToeView;
import org.tictactoe.view.XCellView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToeController implements MouseListener {
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        this.view.setModel(model);
        this.view.addMouseListener(this);
    }

    public void cellClicked(int row, int column) {
        model.updateCell(row, column);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / view.getCellHeight();
        int column = e.getX() / view.getCellWidth();
        if ( model.isValidMove(row, column)) {
            model.switchPlayer();
            cellClicked(row, column);
            Cell cell = model.getCell(row, column);
            view.updateCellView(row, column,
                    cell.getSymbol() == Symbol.X ?
                            new XCellView(view.getCellWidth(), view.getCellHeight(), cell) :
                            new OCellView(view.getCellWidth(), view.getCellHeight(), cell));
            view.update();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
