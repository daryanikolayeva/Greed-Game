//////////////////////////////////////////////
/// Class for menu items: start or exit the menu
/// Extends Selectable interface
/// ////////////////////////////////////////
public class MenuItems implements Selectable {
    private String name;
    private boolean startGame;

    ////////////////////////////////////////////////////
/// Constructor
/// Initializes menu item with name and whether it starts the game
/// Boolean startGame( instance var) is true for start game, and false for exit
/// //////////////////////////////////////////////
    public MenuItems(String name, boolean startGame) {
        this.name = name;
        this.startGame = startGame;
    }

    /////////////////////////////////////
/// Returns name of the menu item
/// /////////////////////////////////
    public String getName() {
        return name;
    }

    /////////////////////////////////////////////
/// Method of selectable interface
/// Starts or exits game based on the item
/// /////////////////////////////////////////
    public boolean select(Viewable v, GameLogical gl) {
        if (startGame) {
            return true;
        } else {
            System.exit(0);
            return false;
        }
    }
}