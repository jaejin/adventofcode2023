package day3;

import java.util.List;
import java.util.Objects;

public class Matrix2 {
    private final List<char[]> matrix;
    private final List<Coordinate> coordinates;
    private final int MAX_LINE;
    private final int MAX_COLUMN;


    public Matrix2(List<char[]> matrixList, List<Coordinate> coordinates) {

        this.MAX_LINE = matrixList.size();
        this.MAX_COLUMN = matrixList.getFirst().length;
        this.coordinates = coordinates;
        this.matrix = matrixList;
    }



    private List<Integer> findSurroundValue(Coordinate coordinate) {

       return coordinate.surround(MAX_LINE, MAX_COLUMN).stream().map(this::findNumber).filter(v->v>0).toList();

    }

    public void findSurroundValues() {
        System.out.println(coordinates.stream()
                .map(this::findSurroundValue)
                .filter(l-> l.size()>=2)
                .map(l-> l.getFirst()*l.get(1))
                .reduce(Integer::sum).orElse(0))
        ;
        printMatrix();

    }


    public int findNumber(Coordinate coordinate) {
        char[] line = matrix.get(coordinate.lineNum());
        char currentChar = line[coordinate.columNum()];


        if (Character.isDigit(currentChar)) {
            removeChar(coordinate);
            return Integer.parseInt(leftCharater(coordinate.lineNum(), coordinate.columNum()) + currentChar + rightCharater(coordinate.lineNum(), coordinate.columNum()));
        }
        return 0;
    }



    private char getDigit(Coordinate coordinate) {
        return matrix.get(coordinate.lineNum())[coordinate.columNum()];
    }

    private void removeChar(Coordinate coordinate) {
        matrix.get(coordinate.lineNum())[coordinate.columNum()] = '.';
    }

    private String rightCharater(int lineNum,int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start+1; i < matrix.get(lineNum).length; i++) {
            if(!Character.isDigit(matrix.get(lineNum)[i])) {
                break;
            }
            result.append(matrix.get(lineNum)[i]);
            matrix.get(lineNum)[i] = '.';
        }
        return result.toString();
    }
    private String leftCharater(int lineNum,int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start-1; i > -1;i--) {
            if(!Character.isDigit(matrix.get(lineNum)[i])) {
                break;
            }
            result.insert(0, matrix.get(lineNum)[i]);
                matrix.get(lineNum)[i] = '.';
            }
        return result.toString();
    }

    private void printMatrix() {
        matrix.stream().map(String::new).forEach(System.out::println);
        System.out.println("------------------");
    }
}
