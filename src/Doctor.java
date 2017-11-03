
/** This class models the Doctor in the game. A Doctor has
 *  a position and can move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        //initialize the  row and the col
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport(random) to a random square 
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //teleport to random row and col within the game board 
        int randomR = (int) (Math.random() * 12);
        int randomC = (int) (Math.random() * 12);
        //if user clicks on the doctor the doctors position doesnt change 
        //if doctor is located one spot away from the click then move there 
        //if the doctor is more then one spot away from the click then teleport to random spot
        if ((newRow == row || newRow == row + 1 || newRow == row - 1)
                && (newCol == col || newCol == col + 1 || newCol == col - 1)) {
            //change of position 
            this.col = newCol;
            this.row = newRow;
            //else place doctor in a random spot on the bord 
        } else {
            //fids a random col and row on the board 
            this.col = randomC;
            this.row = randomR;
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        //return the current row position of the doctor
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        //return the current col position of the doctor 
        return this.col;
    }

}
