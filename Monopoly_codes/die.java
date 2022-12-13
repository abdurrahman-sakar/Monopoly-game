package monopolyGame;

import java.util.Random;

public class die {
    int faceNumber; // Die face number

    public die(){
        this.faceNumber = faceNumber;
    }

    public void tossADie(){
        Random num = new Random();
        this.faceNumber = 1 + num.nextInt(6);  // Die values are set
    }

    public int getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(int faceNumber) {
        this.faceNumber = faceNumber;
    }
}
