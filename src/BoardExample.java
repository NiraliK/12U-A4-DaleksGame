
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author niralikantaria
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8, 8);
        b.putPeg(Color.GREEN, 3, 5);
        b.putPeg(Color.BLUE, 1, 2);
        b.removePeg(3, 5);
        b.displayMessage("Hello Everyone");

        while (true) {
            //recieve a click from the user 
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            //put a peg at the click 
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }

    }

}
