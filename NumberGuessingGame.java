import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a number between " + minRange + " and " + maxRange + ".");

        while (true) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("New round! You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the valid range.");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("You ran out of attempts. The secret number was: " + secretNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game over. Your final score is: " + score);
    }
}
