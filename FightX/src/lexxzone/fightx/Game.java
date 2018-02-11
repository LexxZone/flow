package lexxzone.fightx;
import lexxzone.fightx.models.*;
/**
 * Created by Alex Dvoryaninov on 10.02.18
 */
public class Game {

    public static void main (String[] args) {
        Game game = new Game();
        game.init();
    }

    public void init () {

        Fighter firstFighter = new Fighter("First Knight");
        Fighter secondFighter = new Fighter("John Seena");

        firstFighter.getInfo();
        secondFighter.getInfo();


        boolean turn = true;

        do {

            if (turn) {
                secondFighter.damage(firstFighter.hit());
                firstFighter.heal(0);
            } else {
                firstFighter.damage(secondFighter.hit());
                secondFighter.heal(0);
            }

            turn = !turn;
        } while (firstFighter.isLife() && secondFighter.isLife());


       System.out.println(firstFighter.isLife() ? "\n\nВыиграл первый боец!\n" : "\n\nВыиграл второй боец!\n");
       if (firstFighter.isLife()) {
           firstFighter.getInfo();
       } else {secondFighter.getInfo();
       }
    }

  /*  public void turn() {

    }*/

}
