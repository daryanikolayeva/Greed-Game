import java.util.ArrayList;
import java.util.List;

/////////////////////////////////////////
/// Game Logic class, implementing GameLogical interface
/// Tracks users score, possible moves, and player
/// //////////////////////////////////////
public class GameLogic implements GameLogical {
    private int score = 0;
    private List<Move> possibleMoves;
    private PlayerInterface player;

    ////////////////////////////////////////////////////
/// Constructor
    // Initializes move list and a human player
    /// //////////////////////////////////////////////
    public GameLogic() {
        this.possibleMoves = new ArrayList<>();
        this.player = new HumanPlayer();
    }

    ///////////////////////////////////////////
/// Prints current score of the player
/// ///////////////////////////////////////
    public void view() {
        System.out.println("Score: " + score);
    }

    ////////////////////////////////////////////
/// Moves game to the next state
/// Gets user input for move, menu, exit
/// Returns false if user wants to return to menu
/// ////////////////////////////////////////
    public boolean nextState(Viewable v) {
        if (!(v instanceof GameBoard)) {
            return false;
        }

        GameBoard board = (GameBoard) v;
        possibleMoves.clear();

        Move up = new Move("Move Up", -1, 0);
        Move down = new Move("Move Down", 1, 0);
        Move left = new Move("Move Left", 0, -1);
        Move right = new Move("Move Right", 0, 1);

        if (up.isValid(board))
            possibleMoves.add(up);
        if (down.isValid(board))
            possibleMoves.add(down);
        if (left.isValid(board))
            possibleMoves.add(left);
        if (right.isValid(board))
            possibleMoves.add(right);

        if (possibleMoves.isEmpty()) {
            System.out.println("No moves left. Game Over. Score: " + score);
            return false;
        }

        String input = player.chooseMove(possibleMoves);
        if ("0".equals(input)) {
            return false;
        }

        Move selectedMove = null;
        for (int i = 0; i < possibleMoves.size(); i++) {
            Move move = possibleMoves.get(i);
            String direction = move.getName();
            String key = getKeyForDirection(direction);
            if (key.equals(input)) {
                selectedMove = move;
                break;
            }
        }

        if (selectedMove == null) {
            System.out.println("Invalid move. Use u/d/l/r for up/down/left/right, or 0 to menu.");
            return true;
        }

        return selectedMove.select(board, this);
    }

    /////////////////////////////////////////////
/// Resets the game logic to initial state
/// ////////////////////////////////////////
    public void reset() {
        score = 0;
        possibleMoves.clear();
    }

    ////////////////////////////////////////////////////
/// Adds points to player's score
/// /////////////////////////////////////////////////
    public void addScore(int points) {
        this.score += points;
    }

    ////////////////////////////////////////////////////////
    // Returns string corresponding to users input for move direction
    /// //////////////////////////////////////////////////////
    private String getKeyForDirection(String direction) {
        if (direction.equals("Move Up")) {
            return "u"; // Return key for up.
        } else if (direction.equals("Move Down")) {
            return "d"; // Return key for down.
        } else if (direction.equals("Move Left")) {
            return "l"; // Return key for left.
        } else if (direction.equals("Move Right")) {
            return "r";
        } else {
            return "";
        }
    }
}