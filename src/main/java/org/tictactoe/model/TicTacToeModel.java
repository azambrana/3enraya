package org.tictactoe.model;

public class TicTacToeModel {
    private Cell[][] board;
    private int rows;
    private int columns;

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        resetGame();
    }

    private void initializeBoard(int rows, int columns) {
        this.board = new Cell[rows][columns];
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.board[row][column] = new Cell(row, column);
            }
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void initializeGame() {
        this.player1 = new Player("Player 1", Symbol.X);
        this.player2 = new Player("Player 2", Symbol.O);
        this.currentPlayer = player1;
    }


    public Cell[][] getBoard () {
        return this.board;
    }
    public void resetGame() {
        initializeBoard(this.rows, this.columns);
        initializeGame();
    }

    public void updateCell(int row, int column) {
        System.out.println("Updating cell " + row + ", " + column + " with symbol " + this.currentPlayer.getSymbol());
        if (this.isValidMove(row, column)) {
            this.setCellSymbol(row, column);
            this.switchPlayer();
        }
    }

    private void setCellSymbol(int row, int column) {
        this.board[row][column].setSymbol(this.currentPlayer.getSymbol());
    }

    public boolean isValidMove(int row, int column) {
        return !isTie() && !isGameOver() && isCellEmpty(row, column);
    }

    private boolean isGameOver() {
        return false;
    }

    private boolean isTie() {
        return false;
    }

    private boolean isCellEmpty(int row, int column) {
        return this.board[row][column].getSymbol() == Symbol.EMPTY;
    }

    public void switchPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public Cell getCell(int row, int column) {
        return this.board[row][column];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
