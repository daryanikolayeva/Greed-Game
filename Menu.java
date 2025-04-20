import java.util.ArrayList;
import java.util.Scanner;

////////////////////////////////////////
//Main menu class, implments Menuable interface
////////////////////////////////////// 
public class Menu implements Menuable {
    private ArrayList<MenuItems> list;
    private String message;

    //////////////////////////////////////////////
    // Constructor
    // Initializes default options of menu like start, exit, and welcoming
    // message
    /// /////////////////////////////////////////////
    public Menu() {
        this.list = new ArrayList<>();
        this.message = "Welcome to Greed!";
        list.add(new MenuItems("Start Game", true));
        list.add(new MenuItems("Exit", false));
    }

    ///////////////////////////////////////////////
/// Sets message(inst var) to a given string input
/// ////////////////////////////////////////
    public void setMessage(String input) {
        message = input;
    }

    ////////////////////////////////////////////
/// Prints welcoming message and shows menu options
/// ///////////////////////////////////////////
    public void view() {
        printWelcome();
        System.out.println("Options:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        System.out.println("Choose an option: ");
    }

    //////////////////////////////////////////////////////
/// Changes menu state based on users input
/// Returns boolen. True if game started
/// Has scanner for geting user's input
/// ////////////////////////////////////////////////
    public boolean nextState(Viewable v) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int choice = Integer.parseInt(input) - 1;
        MenuItems selectedItem = list.get(choice);
        return selectedItem.select(v, this);

    }

    ////////////////////////////////////////////
/// Resets the menu to initial state after game resets
/// ////////////////////////////////////////
    public void reset() {
        message = "Welcome back!";
    }

    //////////////////////////////////////////
///Prints welcoming message
/// //////////////////////////////////////
    public void printWelcome() {
        System.out.println(message);
    }
}