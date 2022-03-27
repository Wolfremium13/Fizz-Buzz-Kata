import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzShould {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void calculate_fizz_buzz_given_a_list_of_not_numbers_returns_number_format_exception() {
        var givenNumbers = List.of("not_a_number");

        assertThrows(NumberFormatException.class, () -> fizzBuzz.calculate(givenNumbers));
    }

    @Test
    void calculate_fizz_buzz_given_a_list_of_numbers_returns_fizz_on_multiples_of_3() {
        var givenNumbers = List.of("1", "2", "3");
        var expectedNumbers = List.of("1", "2", "Fizz");

        var calculatedNumbers = fizzBuzz.calculate(givenNumbers);

        assertThat(calculatedNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void calculate_fizz_buzz_given_a_list_of_numbers_returns_buzz_on_multiples_of_5() {
        var givenNumbers = List.of("1", "2", "5");
        var expectedNumbers = List.of("1", "2", "Buzz");

        var calculatedNumbers = fizzBuzz.calculate(givenNumbers);

        assertThat(calculatedNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void calculate_fizz_buzz_given_a_list_of_numbers_returns_fizzbuzz_on_multiples_of_3_and_5() {
        var givenNumbers = List.of("1", "3", "5", "15");
        var expectedNumbers = List.of("1", "Fizz", "Buzz", "FizzBuzz");

        var calculatedNumbers = fizzBuzz.calculate(givenNumbers);

        assertThat(calculatedNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void print_fizz_buzz_given_a_list_of_numbers() {
        var expectedNumbers = List.of("1", "Fizz", "Buzz", "FizzBuzz");

        var consoleOutput = fizzBuzz.printInConsole(expectedNumbers);

        assertThat(consoleOutput).isEqualTo(String.join("", expectedNumbers));
    }
}
