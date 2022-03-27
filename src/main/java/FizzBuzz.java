import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class FizzBuzz {

    public FizzBuzz() {
    }

    public List<String> calculate(List<String> givenNumbers) {
        return givenNumbers.stream().map(this::calculateFizzBuzzFrom).toList();
    }

    private String calculateFizzBuzzFrom(String text) {
        final var number = parseToInt(text);
        final boolean isFizz = number % 3 == 0;
        final boolean isBuzz = number % 5 == 0;
        final boolean isFizzBuzz = isFizz && isBuzz;

        if (isFizzBuzz) return "FizzBuzz";
        if (isFizz) return "Fizz";
        if (isBuzz) return "Buzz";
        return text;
    }

    private int parseToInt(String text) {
        return Integer.parseInt(text);
    }

    public String printInConsole(List<String> calculatedNumbers) {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        for (var number : calculatedNumbers) {
            System.out.print(number);
        }
        return outContent.toString();
    }
}
