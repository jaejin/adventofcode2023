package day4;

import day3.Coordinate;
import day3.Day32;
import day3.Matrix2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day41 {
    public void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D41.txt"))) {
            String line;
            List<Card> cards= new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                 String[] values= line.substring(line.indexOf(":")+1).split("\\|");
                cards.add(new Card(values[0],values[1]));
            }

            System.out.println(cards.stream().map(Card::point).filter(p->p>0).reduce(Integer::sum)) ;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        new Day41().run();
    }
}
