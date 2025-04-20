import java.util.List;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////
// Represents a human player in the Greed game, extending the abstract Player class.
////////////////////////////////////////////////////////////////////////////////////////
public class HumanPlayer extends Player {
    private Scanner scanner;

    /////////////////////////////////////////////
    // Constructor
    // Initializes scanner for user's input
    /// ///////////////////////////////////////
    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    //////////////////////////////////////////////////////////////////
    // Gives user a list of possible movements and asks user to choose their move
    /// ////////////////////////////////////////////////////////////
    public String chooseMove(List<Move> possibleMoves) {
        System.out.println("Available Moves:");
        for (Move move : possibleMoves) {
            String direction = move.getName();
            String key = getKeyForDirection(direction);
            System.out.println(direction + " (" + key + ")");
        }
        if (possibleMoves.isEmpty()) {
            System.out.println("No valid moves available.");
        }
        System.out.println("Enter move (u/d/l/r for up/down/left/right, 0 to menu): ");
        return scanner.nextLine().toLowerCase();
    }

    ////////////////////////////////////////////////////////////////////////
    // Returns the key corresponding to a given direction, empty string if no match.
    //////////////////////////////////////////////////////////////////////////////
    private String getKeyForDirection(String direction) {
        if (direction.equals("Move Up")) {
            return "u";
        } else if (direction.equals("Move Down")) {
            return "d";
        } else if (direction.equals("Move Left")) {
            return "l";
        } else if (direction.equals("Move Right")) {
            return "r";
        } else {
            return "";
        }
    }
}