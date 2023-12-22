package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day22 {


    public void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D22.txt"))) {
            String line;
            List<Game> games = new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                String[] splitWord = line.split(":");
                games.add(new Game(splitWord[0],splitWord[1])) ;
            }

            System.out.println(games.stream().map(Game::getPower).reduce(Integer::sum).orElse(0)) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Day22().run();
    }
}
