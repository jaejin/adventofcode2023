package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day21 {





    public void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D21.txt"))) {
            String line;
            List<Game> games = new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                String[] splitWord = line.split(":");
                games.add(new Game(splitWord[0],splitWord[1])) ;
            }

            System.out.println(games.stream().filter(Game::isOk).map(Game::getNumber).reduce(Integer::sum).orElse(0)) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Day21().run();
    }
}
