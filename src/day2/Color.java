package day2;

public enum Color {
    BLUE,
    RED,
    GREEN;



    public static Color resolve(String data) {
        return switch (data) {
            case "blue":
                yield BLUE;
            case "red":
                yield RED;
            case "green":
                yield GREEN;
            default:
                throw new IllegalStateException("Unexpected value: " + data);
        };

    }
}
