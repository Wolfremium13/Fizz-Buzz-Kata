import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class FizzBuzz {

    public FizzBuzz() {
    }

    public List<String> calculate(List<String> givenNumbers) {
        return givenNumbers.stream().map(this::fizzBuzzLogic).toList();
    }

    private String fizzBuzzLogic(String text) {
        final var number = parseToInt(text);
        final var isFizz = number % 3 == 0;
        final var isBuzz = number % 5 == 0;
        final var isFizzBuzz = isFizz && isBuzz;

        if (isFizzBuzz) return "FizzBuzz";
        if (isFizz) return "Fizz";
        if (isBuzz) return "Buzz";
        return text;
    }

    private int parseToInt(String text) {
        return Integer.parseInt(text);
    }

    public String printInConsole(List<String> calculatedNumbers) {
        final var outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        for (var number : calculatedNumbers) {
            System.out.print(number);
        }
        return outContent.toString();
    }
}
