package monopolyGame;

import java.util.Scanner;

public class mainClass {
    board Board;
    static int totalPlayer = 0;
    die Die = new die();
    static int rounds = 0;

    // main constructor
    public mainClass(int totalPlayer) {
        Board = new board(totalPlayer);
    }

    public static void main(String[] args){
        int inputValue, inputRounds;
        boolean catcher = false;

        System.out.println("  MONOPOLY GAME   ");
        Scanner scan = new Scanner(System.in);

        // This block using for taking player count
        do {
            try {
                System.out.print("Enter the number of players to play (2 - 8) (0 for EXIT): ");
                inputValue = scan.nextInt();    // total player count
                catcher = true;                 // if enter correct value then set catcher is true
            }catch(Exception e) {               // if player count input is not integer then print an error and ask again.
                System.out.println("Error: Please enter number between 2 and 8");
                continue;
            }finally {
                scan.nextLine();
            }
            if (catcher){
                totalPlayer = inputValue;      // If input is correct then set the total player global value set.
            }
            if(totalPlayer == 0){              // If input is zero then game will end.
                System.out.println("Exiting Game...");
                System.exit(0);
            }else if(totalPlayer > 8 || totalPlayer < 2) {  // If entering value is not between 2-8 then print error and ask again.
                System.out.println("Error: Invalid player number.\n");
                catcher = false;
            }
        }while (!catcher);

        catcher = false;    // set catcher false for using get player name task.

        // This block takes round count.
        do {
            try {
                System.out.print("Enter the number of round (0 for EXIT): ");
                inputRounds = scan.nextInt();    // get round count.
                catcher = true;
            }catch (Exception e){               // if input is different from integer value then print error massage and ask for input again
                System.out.println("Error: Please enter only integer: ");
                continue;
            }finally {
                scan.nextLine();
            }

            if (catcher){                    // if value is correct then set the rounds with input.
                rounds = inputRounds;
            }
            if(rounds == 0){                  // if input is zero then game will end.
                System.out.println("Exiting Game...");
                System.exit(0);
            }else if(rounds < 0) {            // if input less than zero print error and ask again.
                System.out.println("Error: Invalid rounds number.\n");
                catcher = false;
            }
        }while (!catcher);

        mainClass game = new mainClass(totalPlayer);  // create main object
        game.startGame();                   // Start the game.
    }


    public void startGame(){
        int previousPosition,currentPosition;
        System.out.println("  Game is starting  ");
        int i = 0;

        while (true){
            previousPosition = Board.getCurrentPlayer().getPosition();  // hold previous position of current player
            System.out.println("\n" + (Board.getCurrentPlayer().getPlayerName()) + " position is" + Board.Square[previousPosition][0]); // print player position before toss die
            Board.getCurrentPlayer().setPosition(Board.normalizePosition(Board.getCurrentPlayer().getPosition() + Board.getCurrentPlayer().tossADie(Die))); // toss a die and set new position current player
            currentPosition = Board.getCurrentPlayer().getPosition(); // get new position of player
            System.out.println((Board.getCurrentPlayer().getPlayerName()) + " position is " + Board.Square[Board.getCurrentPlayer().getPosition()][0] + "."); // print new position of player

            if (Board.getCurrentPlayer().getPosition() == 4 || Board.getCurrentPlayer().getPosition() == 38){  // reduce player money for tax
                i = Integer.parseInt(Board.Square[Board.getCurrentPlayer().getPosition()][2]);
                i = 0 - i;
                Board.getCurrentPlayer().setPlayerMoney(i);
            }
            if (previousPosition > currentPosition){       // if player pass start point increase 1 player rounds and add 200 money.
                Board.getCurrentPlayer().nextLap();
                Board.getCurrentPlayer().setPlayerMoney(200);
                System.out.println((Board.getCurrentPlayer().getPlayerName()) + " GO to START POINT.");  // Print if player passed start point.
            }
            if (Board.getCurrentPlayer().getPosition() == 30){ // GO TO JAIL
                Board.getCurrentPlayer().setPosition(10);
                System.out.println((Board.getCurrentPlayer().getPlayerName()) + " GO to JAIL. " + (Board.getCurrentPlayer().getPlayerName()) + " position is " + Board.Square[Board.getCurrentPlayer().getPosition()][0] + ".");  // Print new position of player.
            }
            System.out.println((Board.getCurrentPlayer().getPlayerName()) + " completed " + Board.getCurrentPlayer().getTotalLap() + " rounds and has " + Board.getCurrentPlayer().getPlayerMoney() + " money ");  // Print completed round and money of player.
            if (Board.getCurrentPlayer().rounds >= this.rounds){ // If all rounds is completed then end game.
                break;
            }
            Board.nextPlayer(); // Switch next player.
            i++;
        }

        System.out.println("\nGame over! Player " + (Board.getCurrentPlayer().getPlayerName()) + " Win!"); // print end game and result
    }
}
