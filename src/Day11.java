import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Day11 {

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
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D11.txt"))) {
            String line;
            List<Pair> numbers = new ArrayList<>();
            while((line=fileReader.readLine()) != null) {
                Pair pair = new Pair();

                for(int i =0;i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        int number = line.charAt(i) -'0';
                        if (pair.getFirst() < 0) {
                            pair.setFirst(number);
                            pair.setLast(number);
                        } else {
                            pair.setLast(number);
                        }
                    };

                }
                numbers.add(pair);;
            }

            System.out.println(numbers.stream()
                    .map(Pair::toNumber).peek(System.out::println).reduce(Integer::sum).orElse(-1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Day11.run();
    }
}
