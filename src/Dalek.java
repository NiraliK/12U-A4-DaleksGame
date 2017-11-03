
/** This class models a Dalek in the game. A Dalek has
 *  a position and can advance towards the Doctor.
 */
public class Dalek {
    //varibles created 
    private int row, col;
    private boolean hasCrashed = false;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        //initialize the row and col variable
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        //if the doctors row position is greater then the daleks row 
        if(doc.getRow() > this.row){
            //dalek moves towards the doctor 
            this.row ++;    
        //if the doctors row is less then daleks row 
        }else if(doc.getRow() < this.row){
            //dalek moves back towards the doctor 
            this.row --;
        }
        
        //if the doctors col position is greater then the daleks col 
        if(doc.getCol() > this.col){
            //dalek moves towards the doctor 
            this.col ++;
        //if the doctors col position is less then the daleks col 
        }else if(doc.getCol() < this.col){
            //the dalek moves back one to the doctor 
            this.col --;
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek row.
     */
    public int getRow() {
        //return the final row position of the dalek 
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek column.
     */
    public int getCol() {
        //return the final col position of the dalek 
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        //the dalek has craashed send a true statement 
        hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        //return the final result of the boolean 
        return hasCrashed;
    }

}
