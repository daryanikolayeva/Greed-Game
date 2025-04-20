import java.util.Random;

////////////////////////////////////////////
/// Class representing Game Board
/// Implmenets GameBoardable interface
/// ///////////////////////////////////////
public class GameBoard implements GameBoardable {
    private int[][] board;
    private int rows;
    private int cols;
    private int playerRow, playerCol;

    ///////////////////////////////////////
/// Constructor
/// Initializes size of board
/// Every time new is created,
/// it resets(calls reset function that fills board with random digits 1-9 and places player in the center of board)
/// ////////////////////////////////////
    public GameBoard() {
        this.rows = 20;
        this.cols = 80;
        this.board = new int[rows][cols];
        reset();
    }

    //////////////////////////////////////////////////////
/// Shows current state of the board
////////////////////////////////////////////////////
    public void view() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '@') {
                    System.out.print((char) board[i][j]);
                } else if (board[i][j] == 0) {
                    System.out.print('.');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    ////////////////////////////////////////
/// Resets the board to initial state
/// Fills the board, and updates player location
/// ///////////////////////////////////
    public void reset() {
        fillBoard(board, rows, cols);
        playerRow = rows / 2;
        playerCol = cols / 2;
    }

    //////////////////////////////
/// Returns number of rows in the board
/// //////////////////////////
    public int getRows() {
        return rows;
    }

    //////////////////////////////
/// Returns number of columns in the board
/// //////////////////////////
    public int getCols() {
        return cols;
    }

    ////////////////////////////////////////////////
/// Returns charatcter at a given board position
/// //////////////////////////////////////////
    public char getTokenPosition(int row, int col) {
        if (board[row][col] == '@') {
            return '@';
        } else if (board[row][col] == 0) {
            return '.';
        } else {
            return (char) (board[row][col] + '0');
        }
    }

    /////////////////////////////////////////////////
/// Fills the board, given board itself as 2d array, num of cols, amd rows
/// Fills with random digits 1-9
/// PLayer at the center
/// //////////////////////////////////////////
    public void fillBoard(int[][] array, int rows, int columns) {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = rand.nextInt(9) + 1;
            }
        }
        int centerRow = rows / 2;
        int centerCol = columns / 2;
        array[centerRow][centerCol] = '@';
    }

    //////////////////////////////
/// Returns row where player is at the moment
/// //////////////////////////
    public int getPlayerRow() {
        return playerRow;
    }

    //////////////////////////////
/// Returns column where player is at the moment
/// //////////////////////////
    public int getPlayerCol() {
        return playerCol;
    }

    ///////////////////////////////////////////////////
    // Returns boolean, based on if given row and col is within bounds of our board
    //////////////////////////////////////////////////
    public boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    ////////////////////////////////////////////
/// Return boolean, based on if character at given row and col is a digit or '.'
/// ///////////////////////////////////////
    public boolean hasDigit(int row, int col) {
        if (!isWithinBounds(row, col))
            return false;
        int value = board[row][col];
        return value >= 1 && value <= 9;
    }

    ////////////////////////////////////////////////////////////
/// Moves the player to a new position
/// Clears previous position
/// Moves "@". Updates player's coordinates
/// //////////////////////////////////////////////////////////
    public int movePlayer(int newRow, int newCol, int rowDelta, int colDelta) {
        int points = board[newRow][newCol];
        board[playerRow][playerCol] = 0;
        board[newRow][newCol] = '@';
        playerRow = newRow;
        playerCol = newCol;
        return points;
    }
}