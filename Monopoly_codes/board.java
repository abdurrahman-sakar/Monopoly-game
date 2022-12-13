package monopolyGame;

import java.util.Scanner;

public class board extends square{
    int totalPlayer;
    int currentPlayer = 0;
    player[] Players;

    public board(int totalPlayer) {
        this.totalPlayer = totalPlayer;
        Players = new player[this.totalPlayer];  // create Players array from player object
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < Players.length; i++){
            String playerName;
            do{
                System.out.print("Enter Player " + (i + 1) + " Name: ");
                playerName = scan.nextLine();    // get player name from keyboard

                if (playerName.isEmpty()){      // if player name is entering empty then print error and ask again
                    System.out.println("Error: Player name must not be empty. ");
                }
            }while (playerName.isEmpty());
            Players[i] = new player(i, playerName);    // create a player
        }
    }
    public int normalizePosition(int position) {
        return position % 40;     // if player pass start point then normalise position
    }

    public player getCurrentPlayer() {  // get current player method
        return Players[currentPlayer];
    }

    public void nextPlayer() {                   // switch next player
        if(++currentPlayer >= Players.length){   // if all player playing then switch first player
            currentPlayer = 0;
        }
    }

}
