//////////////////////////////////////////
// Class for player's movement
//Implements Selectable interface
/// //////////////////////////////////////
public class Move implements Selectable {
    private String name;
    private int rowM, colM;

    //////////////////////////////////
/// Constructor
/// initializes move with it's name and change in position
/// ////////////////////////////
    public Move(String name, int rowM, int colM) {
        this.name = name;
        this.rowM = rowM;
        this.colM = colM;
    }

    ////////////////////////////////
/// Returns name of the move
/// /////////////////////////
    public String getName() {
        return name;
    }

    //////////////////////////////////////////////////////////////////////
/// Checks if move is a valid one(i.e in bounds of game board, and stil not '.'(not eaten yet))
/// //////////////////////////////////////////////////////////////////////
    public boolean isValid(GameBoard board) {
        int currRow = board.getPlayerRow();
        int currCol = board.getPlayerCol();
        int targetRow = currRow + rowM;
        int targetCol = currCol + colM;
        return board.isWithinBounds(targetRow, targetCol) && board.hasDigit(targetRow, targetCol);
    }

    //////////////////////////////////////////////////////////////
/// Processes the move, updates board, returns game status, updates player's score
/// ///////////////////////////////////////////////////////////
    public boolean select(Viewable v, GameLogical gl) {
        if (!(v instanceof GameBoard) || !(gl instanceof GameLogic)) {
            return true;
        }
        GameBoard board = (GameBoard) v;
        GameLogic logic = (GameLogic) gl;
        int currRow = board.getPlayerRow();
        int currCol = board.getPlayerCol();
        int targetRow = currRow + rowM;
        int targetCol = currCol + colM;
        int scoreToAdd = board.movePlayer(targetRow, targetCol, rowM, colM);
        logic.addScore(scoreToAdd);
        return true;
    }
}