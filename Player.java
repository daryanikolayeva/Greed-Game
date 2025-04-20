//////////////////////////////////////////////
//Abstract class for Player
//Implementing PlayerInterface
//////////////////////////////////////////////////

import java.util.List;

public abstract class Player implements PlayerInterface {
    public abstract String chooseMove(List<Move> possibleMoves);
}