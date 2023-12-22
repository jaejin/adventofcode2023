package day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Card2 {
    int number;
    Set<Integer> winners;
    Set<Integer> numbers;

    Card2(String cardString, String winnerString, String numberString) {
        String[] cardSplit= cardString.split(" ");
        number = Integer.parseInt(cardSplit[cardSplit.length-1]);
        winners= Arrays.stream(winnerString.split(" "))
                .map(String::trim)
                .filter(s-> !s.isEmpty())
                .map(Integer::parseInt).collect(Collectors.toSet());
        numbers= Arrays.stream(numberString.split(" "))
                .map(String::trim)
                .filter(s-> !s.isEmpty())
                .map(Integer::parseInt).collect(Collectors.toSet());
    }

    public int point() {
        Set<Integer> inter = new HashSet<>(numbers);
        inter.retainAll(winners);
        if (!inter.isEmpty()) {
            return (int)Math.pow(2,inter.size()-1);
        }
        return 0;
    }

    public int interSectionSize() {
        Set<Integer> inter = new HashSet<>(numbers);
        inter.retainAll(winners);
        if (!inter.isEmpty()) {
            return inter.size();
        }
        return 0;
    }
}
