import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class ReverseInput {
    static final String[] WORDS = {
            "hello", "string", "java", "keyboard", "reverse", "palindrome", "guess", "random", "scanner", "programmer", "mouse", "input"
    };

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the String Processor!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Reverse characters");
            System.out.println("2. Reverse word order");
            System.out.println("3. Check palindrome");
            System.out.println("4. Reverse Guess Game");
            System.out.println("5. Jumble Word Game");
            System.out.println("6. Exit");
            System.out.print("Enter option number: ");

            String choice = scanner.nextLine();

            if (choice.equals("6")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Enter text: ");
                    String input1 = scanner.nextLine();
                    String reversed = new StringBuilder(input1).reverse().toString();
                    printFramedTyping("Reversed: " + reversed);
                    break;

                case "2":
                    System.out.print("Enter text: ");
                    String input2 = scanner.nextLine();
                    String[] words = input2.trim().split("\\s+");
                    StringBuilder wordReversed = new StringBuilder();
                    for (int i = words.length - 1; i >= 0; i--) {
                        wordReversed.append(words[i]).append(" ");
                    }
                    printFramedTyping("Word Order Reversed: " + wordReversed.toString().trim());
                    break;

                case "3":
                    System.out.print("Enter text: ");
                    String input3 = scanner.nextLine();
                    String cleaned = input3.replaceAll("[\\W_]", "").toLowerCase();
                    String reversedClean = new StringBuilder(cleaned).reverse().toString();
                    if (cleaned.equals(reversedClean)) {
                        printFramedTyping("Yes, it's a palindrome!");
                    } else {
                        printFramedTyping("No, it's not a palindrome.");
                    }
                    break;

                case "4":
                    playReverseGuessGame(scanner);
                    break;

                case "5":
                    playJumbleGame(scanner);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static void printFramedTyping(String text) throws InterruptedException {
        int length = text.length();
        String border = "+" + "-".repeat(length + 2) + "+";

        System.out.println(border);
        System.out.print("| ");
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(30);
        }
        System.out.println(" |");
        System.out.println(border);
    }

    public static void playReverseGuessGame(Scanner scanner) throws InterruptedException {
        Random rand = new Random();
        String word = WORDS[rand.nextInt(WORDS.length)];
        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println("\nReverse Guess Game!");
        System.out.println("Guess the original word: \"" + reversed + "\"");
        System.out.print("> ");
        String guess = scanner.nextLine().trim();

        if (guess.equalsIgnoreCase(word)) {
            printFramedTyping("Correct!");
        } else {
            printFramedTyping("Nope! The correct word was: " + word);
        }
    }

    public static void playJumbleGame(Scanner scanner) throws InterruptedException {
        Random rand = new Random();
        String word = WORDS[rand.nextInt(WORDS.length)];
        String jumbled = jumbleWord(word);

        System.out.println("\nJumble Word Game!");
        System.out.println("Unscramble the word: \"" + jumbled + "\"");
        System.out.print("> ");
        String guess = scanner.nextLine().trim();

        if (guess.equalsIgnoreCase(word)) {
            printFramedTyping("Correct!");
        } else {
            printFramedTyping("Nope! The correct word was: " + word);
        }
    }

    public static String jumbleWord(String word) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }

        while (true) {
            Collections.shuffle(chars);
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            if (!sb.toString().equalsIgnoreCase(word)) {
                return sb.toString();
            }
        }
    }
}
