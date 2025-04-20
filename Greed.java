
public class Greed extends Game {
    ////////////////////////////////
    /// Constructor:
    /// Initializes game logic, game board and menu
    /// ////////////////////////////
    public Greed() {
        super(new GameLogic(), new GameBoard(), new Menu());
    }

    /////////////////////////////////////////
/// Main method.Creates greed game and runs it
/// ////////////////////////////////////
    public static void main(String[] args) {
        Greed game = new Greed();
        game.run();
    }
}