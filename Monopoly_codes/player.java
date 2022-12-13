package monopolyGame;

public class player {
    int rounds = 0;              // Completed rounds
    int position = 0;            // Player position square
    int id;                      // Player unique id
    String playerName;           // Player name
    int playerMoney = 1500;      // Player initial money

    public player(int id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }

    public int tossADie(die Die) {
        Die.tossADie();
        int faceNumber1 = Die.getFaceNumber();
        Die.tossADie();
        int faceNumber2 = Die.getFaceNumber();
        System.out.print(this.playerName + " toss die. Face numbers are " + faceNumber1 + " and " + faceNumber2 + ". Total " + (faceNumber1 + faceNumber2) + ".\n");
        return faceNumber1 + faceNumber2;
    }

    public void nextLap() {
        this.rounds++;
    }
    public int getTotalLap() {
        return this.rounds;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlayerMoney() {
        return this.playerMoney = playerMoney + this.playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getId() {
        return this.id;
    }
}
