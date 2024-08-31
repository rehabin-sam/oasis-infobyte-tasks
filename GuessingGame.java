import java.util.*;

public class GuessingGame {
    static List<Integer> scoreList = new ArrayList<>();

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.startMenu(scoreList);
    }

    public void startMenu(List<Integer> scoreList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("1) Start Game");
        System.out.println("2) View Scoreboard");
        System.out.println("3) Exit");
        System.out.println("--------------------");
        try {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nSet the range for the numbers: ");
                    int range = scanner.nextInt();
                    int targetNumber = generateRandomNumber(range);
                    playGame(targetNumber);
                    break;
                case 2:
                    showScoreboard();
                    break;
                case 3:
                    System.out.println("\nThank you for playing!");
                    System.exit(0);
                    break;
                default:
                    throw new InputMismatchException("Invalid input. Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            startMenu(scoreList);
        }
    }

    public int generateRandomNumber(int range) {
        Random random = new Random();
        return random.nextInt(range) + 1;
    }

    public void playGame(int targetNumber) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int guess;
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess > targetNumber) {
                System.out.println("Too high, try again.");
            } else if (guess < targetNumber) {
                System.out.println("Too low, try again.");
            }
        } while (guess != targetNumber);

        System.out.println("\nCongratulations! You guessed the correct number in " + attempts + " attempts.");
        scoreList.add(attempts);
        startMenu(scoreList);
    }

    public void showScoreboard() {
        System.out.println("--------------------");
        System.out.println("Scoreboard");
        System.out.println("--------------------");
        System.out.println("Your best performance today:");
        Collections.sort(scoreList);
        for (Integer score : scoreList) {
            System.out.println("Completed the game in " + score + " attempts.");
        }
        System.out.println(" ");
        startMenu(scoreList);
    }
}
