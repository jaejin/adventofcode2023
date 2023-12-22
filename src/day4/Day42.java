package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day42 {
    public void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D41.txt"))) {
            String line;
            List<Card2> cards= new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                 String[] values= line.substring(line.indexOf(":")+1).split("\\|");
                cards.add(new Card2(line.substring(0,line.indexOf(":")),values[0],values[1]));

            }

            int[] cardA = new int[cards.size()];
            Arrays.fill(cardA, 1);

            for (int i=0;i<cards.size();i++) {
                int size= cards.get(i).interSectionSize();
                System.out.printf("card %s size %s \n",cards.get(i).number, size);
                System.out.println("######");
                for (int j=i+1;j<=i+size && j< cardA.length;j++) {
                    cardA[j] +=cardA[i];
                    System.out.printf("card %s total cards %s \n", (j+1),cardA[j]);
                }
                System.out.println("######");
            }
            System.out.println("--------------------");
            int sum = 0;
            for (int i=0;i<cards.size();i++) {
                System.out.println(cardA[i]);
                sum += cardA[i];
            }

            System.out.println(sum);
                    ;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        new Day42().run();
    }
}
