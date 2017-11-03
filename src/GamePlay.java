
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
public class GamePlay {
    //board variable created 
    Board b;
    //Doctor variable created 
    Doctor doc;
    Dalek D1;
    Dalek D2;
    Dalek D3;
    boolean finish = false;
    /**
     * Instance variables go up here Make sure to create a Board, 3 Dalek, and a
     * Doctor
     */
    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public GamePlay() {
       //a 12X12 game boad created 
        b = new Board(12, 12);

        //doctor created 
        doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        //draw and make the doctor on the board  (doctor = green)
        b.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        //three dalek created 
        D1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        D2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        D3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // draw and make the three daleks on the board  (daleks black)
        b.putPeg(Color.BLACK, D1.getRow(), D1.getCol());
        b.putPeg(Color.BLACK, D2.getRow(), D1.getCol());
        b.putPeg(Color.BLACK, D3.getRow(), D1.getCol()); 
    }
    
    public void playGame() {
        while(! finish){
        //user cooridnate 
        Coordinate click = b.getClick(); 
        
        //Player Movements 
        //Remove all the players 
        b.removePeg(doc.getRow(), doc.getCol());
        b.removePeg(D1.getRow(), D1.getCol());
        b.removePeg(D2.getRow(), D2.getCol());
        b.removePeg(D3.getRow(), D3.getCol());
        
        //get coordinates of the doctor 
        int row = click.getRow();
        int col = click.getCol();
        
        //doc position sent to its class 
        doc.move(row, col);
        
        //doctor is drawn again 
        b.putPeg(Color.green, doc.getRow(), doc.getCol());
        
        //Dalek 1 Movements
        D1.advanceTowards(doc);
        b.putPeg(Color.black, D1.getRow(), D1.getCol());
        //Dalek 2 Movements 
        D2.advanceTowards(doc);
        b.putPeg(Color.black, D2.getRow(), D2.getCol());
        //Dalek 3 Movements 
        D3.advanceTowards(doc);
        b.putPeg(Color.black, D3.getRow(), D3.getCol());
      
        //Dalek Collisions
        //A red peg is places when two daleks crash into each other 
        //if dalek 1 and 2 crash
        if (D1.getRow() == D2.getRow()
                && D1.getCol() == D2.getCol()) {
            D1.crash();
            D2.crash();
            //replaced with a red peg 
            b.putPeg(Color.red, D1.getRow(), D1.getCol());
        }
        // If daleks 1 and 3 crash 
        if (D1.getRow() == D3.getRow()
                && D1.getCol() == D3.getCol()) {
            D1.crash();
            D3.crash();
            //replace it with a red oeg 
            b.putPeg(Color.red, D1.getRow(), D1.getCol());
        }
        // If  dalek 2 crashes with dalek 3 
        if (D2.getRow() == D3.getRow()
                && D2.getCol() == D3.getCol()) {
            D2.crash();
            D3.crash();
            //red peg is replacs the crash sence 
            b.putPeg(Color.red, D3.getRow(), D3.getCol());
        }
        //if all of the daleks crash 
        if (D1.getRow() == D2.getRow() && D1.getRow() == D3.getRow() && D2.getRow() == D3.getRow() && 
            D1.getCol() == D2.getCol() && D1.getCol() == D3.getCol() && D2.getCol() == D3.getCol()) {
            b.displayMessage("ALL THE DALEKS HAVE CRASHED!! CONGARTS THE DOCTOR HAS WON!!");
            finish = true;
        }

        //Dalek and doctor crash 
        //doctor and each dalek crash 
        if (doc.getRow() == D1.getRow() && doc.getCol() == D1.getCol() || 
            doc.getRow() == D2.getRow() && doc.getCol() == D2.getCol() || 
            doc.getRow() == D3.getRow() && doc.getCol() == D3.getCol()) {
            b.displayMessage("THE DOCTOR HAS BEEN CAPTURED AND THE DALEKS HAVE WON!!");
            finish = true;
        }

        //In a rare case: if al the dalek and doctor crash 
        if (D1.getRow() == D2.getRow() && D2.getRow() == D3.getRow() && D1.getRow() == D3.getRow() &&
            doc.getRow() == D1.getRow() && doc.getRow() == D2.getRow() && doc.getRow() == D3.getRow() &&
            D1.getCol() == D2.getCol() && D2.getCol() == D3.getCol() && D1.getCol() == D3.getCol() &&
            doc.getCol() == D1.getCol() && doc.getCol() == D2.getCol() && doc.getCol() == D3.getCol()) {
            b.displayMessage("GAME OVER!! EVERYONE HAS CRASHED!!");
            finish = true;
        }   
        }
    }
}
