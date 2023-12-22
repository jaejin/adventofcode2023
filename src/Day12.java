import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day12 {

    enum Numbers {
        ONE("one", 3, 1),
        TWO("two",3,2),
        THREE("three",5,3),
        FOUR("four",4,4),
        FIVE("five",4,5),
        SIX("six", 3,6),
        SEVEN("seven", 5,7),
        EIGHT("eight", 5,8),
        NINE("nine",4,9);

        private String value;
        private int length;

        private int realNum;

        Numbers(String value, int length, int realNum) {
            this.value = value;
            this.length = length;
            this.realNum = realNum;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getRealNum() {
            return realNum;
        }
    }

    private boolean isNotOver(String lestString, Numbers numbers) {
        return lestString.length() > numbers.length;
    }

    static class Pair {
        private int first = -1;
        private int last = -1;

        public void setFirst(int first) {
            this.first = first;
        }

        public void setLast(int last) {
            this.last = last;
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }

        public int toNumber() {
            return Integer.parseInt(first+"" + last);
        }
    }
    public static void run()  {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D12.txt"))) {
            String line;
            List<Pair> numbers = new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                System.out.print(line);
                Pair pair = new Pair();

                int currentPosition = 0;
                while(currentPosition < line.length()) {
//                    System.out.printf("charAt %c\n", line.charAt(currentPosition));

                    for (Numbers num: Numbers.values()) {
//                        System.out.println(line.substring(currentPosition));
//                        System.out.printf("current Value %s length %s restString %s substring %s %s \n",num.value, num.length, line.substring(currentPosition), line.substring(currentPosition,currentPosition+ num.length),num.name().toLowerCase().equals(line.substring(currentPosition,currentPosition+ num.length)));
                        if(line.substring(currentPosition).length() >= num.length && line.substring(currentPosition,currentPosition+ num.length).equals(num.getValue())) {
                            if (pair.getFirst() < 0) {
                                pair.setFirst(num.getRealNum());
                                pair.setLast(num.getRealNum());
                            } else {
                                pair.setLast(num.getRealNum());
                            }
                        }
                    }

                    if (Character.isDigit(line.charAt(currentPosition))) {
                        int number = line.charAt(currentPosition) -'0';
                        if (pair.getFirst() < 0) {
                            pair.setFirst(number);
                            pair.setLast(number);
                        } else {
                            pair.setLast(number);
                        }
                    };
                    currentPosition++;

                }

                System.out.println(" "+ pair.toNumber());
                numbers.add(pair);;
            }

            System.out.println(numbers.stream()
                    .map(Pair::toNumber).peek(System.out::println).reduce(Integer::sum).orElse(-1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Day12.run();
    }
}
