public interface GameBoardable extends Viewable {
    void reset();

    int getRows();

    int getCols();

    char getTokenPosition(int row, int col);
}