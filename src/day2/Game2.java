package day2;

import java.util.Arrays;
import java.util.List;

public class Game2 {
    private int number;
    private int blue;
    private int red;
    private int green;

    Game2(String gameString, String rest) {
        this.number = getGameNumber(gameString);
        splitWord(rest).forEach(this::addValue);
    }

    private List<String> splitWord(String rest) {
        String[] sets = rest.split(";");
        return Arrays.stream(sets).toList().stream().flatMap(s -> Arrays.stream(s.split(","))).toList();
    }


    public boolean isOk() {
        return red <=12 && green <= 13 && blue <= 14;
    }


    public void setBlue(int blue) {
        if (this.blue > 0) {
            this.blue = Math.min(this.blue,blue);
        } else {
            this.blue = blue;
        }


    }


    public void setRed(int red) {
        if (this.red > 0) {
            this.red = Math.min(this.red,red);
        } else {
            this.red = red;
        }

    }


    public void setGreen(int green) {
        if ( this.green > 0) {
            this.green = Math.min(this.green, green);
        } else {
            this.green = green;
        }


    }

    private int getGameNumber(String gameString) {
        return Integer.parseInt(gameString.replace("Game ","")) ;
    }

    private void addValue(String data) {
        String[] splitData= data.trim().split(" ");

        switch (Color.resolve(splitData[1])) {
            case RED:
                this.setRed(Integer.parseInt(splitData[0]));
            case GREEN:
                this.setGreen(Integer.parseInt(splitData[0]));
            case BLUE:
                this.setBlue(Integer.parseInt(splitData[0]));
        }
    }

    public int getNumber() {
        return number;
    }


    public int getPower() {
        return this.blue * this.red * this.green;
    }
}
