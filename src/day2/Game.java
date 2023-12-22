package day2;

import java.util.Arrays;
import java.util.List;

public class Game {
    private int number;
    private int blue;
    private int red;
    private int green;

    Game(String gameString, String rest) {
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
        this.blue = Math.max(this.blue,blue);

    }


    public void setRed(int red) {
        this.red = Math.max(this.red,red);
    }


    public void setGreen(int green) {
        this.green = Math.max(this.green, green);
    }

    private int getGameNumber(String gameString) {
        return Integer.parseInt(gameString.replace("Game ","")) ;
    }

    private void addValue(String data) {
        String[] splitData= data.trim().split(" ");

        switch (Color.resolve(splitData[1])) {
            case RED:
                this.setRed(Integer.parseInt(splitData[0]));
                break;
            case GREEN:
                this.setGreen(Integer.parseInt(splitData[0]));
                break;
            case BLUE:
                this.setBlue(Integer.parseInt(splitData[0]));
                break;
        }
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return String.format("red %s green %s blue %s",red, green,blue);
    }
    public int getPower() {
        return this.blue * this.red * this.green;
    }
}
