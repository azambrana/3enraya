package org.tictactoe;

import org.tictactoe.controller.TicTacToeController;
import org.tictactoe.model.TicTacToeModel;
import org.tictactoe.view.TicTacToeView;

import javax.swing.JFrame;

public class TicTacToe {
    private TicTacToeController controller;
    private TicTacToeView view;
    private TicTacToeModel model;

    private JFrame window;

    public TicTacToe() {
        this.model = new TicTacToeModel(3, 3);
        this.view = new TicTacToeView(3, 3, model);
        this.controller = new TicTacToeController(model, view);

        this.window = new JFrame("Tic Tac Toe");
        this.window.setSize(view.getWidth(), view.getHeight());
        this.window.setPreferredSize(view.getPreferredSize());
        this.window.setLayout(null);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.add(view);
        this.window.pack();
        this.window.setVisible(true);
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
}