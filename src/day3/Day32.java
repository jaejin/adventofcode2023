package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day32 {
    public void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D31.txt"))) {
            String line;
            StringBuffer data = new StringBuffer();
            int lineNum = 0;
            List<char[]> datas = new ArrayList<>();
            List<Coordinate> coordinates = new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                for(int columNum =0;columNum<line.length();columNum++) {
                    char c = line.charAt(columNum);
                    if (!Character.isDigit(c) && c != '.') {
                        System.out.printf("lineNum %s columNum %s charater %s%n",lineNum, columNum, c);
                        coordinates.add(new Coordinate(lineNum, columNum));
                    }
                }
                datas.add(line.toCharArray());
                data.append(line).append("\r\n");
                lineNum++;
            }
            System.out.println(data);
            System.out.println(datas);

            Matrix2 matrix = new Matrix2(datas, coordinates);
            matrix.findSurroundValues();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        new Day32().run();
    }
}
