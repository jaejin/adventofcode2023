package day3;

import java.util.List;
import java.util.stream.Stream;

public record Coordinate(int lineNum, int columNum) {

    List<Coordinate> surround(int maxLine, int maxColumn) {
        return Stream.of(new Coordinate(this.lineNum()+1, this.columNum()-1),
                        new Coordinate(this.lineNum()+1, this.columNum()),
                        new Coordinate(this.lineNum()+1, this.columNum()+1),
                        new Coordinate(this.lineNum(), this.columNum()-1),
                        new Coordinate(this.lineNum(), this.columNum()+1),
        new Coordinate(this.lineNum()-1, this.columNum()-1),
                new Coordinate(this.lineNum()-1, this.columNum()),
                new Coordinate(this.lineNum()-1, this.columNum()+1)
                        )
                .filter(c -> c.lineNum() > -1 && c.lineNum() < maxLine && c.columNum() > -1 && c.columNum() < maxColumn)
                .toList();
    }

}
