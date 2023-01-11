import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("./words.txt"));
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            //System.out.println(scanner.nextLine());
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size())); // random number from the word list

        //System.out.println(word);

        List<Character> guesses  = new ArrayList<>();


        // create a scanner for keyboard inputs from the user
        Scanner keyboard = new Scanner(System.in);

        int numWrongGuesses = 0;

        while (true) {

            System.out.println("");
            switch (numWrongGuesses) {
                case 1:
                    printHang1();
                break;
                case 2:
                    printHang2();
                break;
                case 3:
                    printHang3();
                break;
                case 4:
                    printHang4();
                break;
                case 5:
                    printHang5();
                break;
                case 6:
                    printHang6();
                break;
                case 7:
                    printHang7();
                    System.out.println((""));
                    System.out.println(("You Lose!! :-( :-( :-("));
                    System.out.println(("The word was :" + word));
                    System.out.println((""));
                break;
                default:
                break;
            }

            if (numWrongGuesses == 7) {
                break;
            }

            System.out.println((""));
            System.out.println((""));
            int currCorrectCount = printState(word, guesses);
            if (!guessLetter(word, guesses, keyboard)) {
                continue;
            }

            int newCorrectCount = printState(word, guesses);
            if (newCorrectCount == word.length()) {
                System.out.println((""));
                System.out.println(("You Win!! :-) :-) :-)"));
                System.out.println((""));
                break;
            }

            if (newCorrectCount == currCorrectCount) {
                numWrongGuesses++;
            }

        }

    }

    private static void printHang1() {
        System.out.println("_|_");
    }
    private static void printHang2() {
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        printHang1();
    }

    private static void printHang3() {
        System.out.println("_____");
        printHang2();
    }

    private static void printHang4() {
        System.out.println("_______");
        System.out.println(" |   |");
        System.out.println(" |   O");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        printHang1();
    }

    private static void printHang5() {
        System.out.println("_______");
        System.out.println(" |   |");
        System.out.println(" |   O");
        System.out.println(" |   |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        printHang1();
    }

    private static void printHang6() {
        System.out.println("_______");
        System.out.println(" |   |");
        System.out.println(" |   O");
        System.out.println(" |  \\|/");
        System.out.println(" |   |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        printHang1();
    }

    private static void printHang7() {
        System.out.println("_______");
        System.out.println(" |   |");
        System.out.println(" |   O");
        System.out.println(" |  \\|/");
        System.out.println(" |   |");
        System.out.println(" |  / \\");
        System.out.println(" |");
        System.out.println(" |");
        printHang1();
    }

    private static boolean guessLetter(String word, List<Character> guesses, Scanner keyboard) {
        System.out.println("Enter a letter: ");
        String guess = keyboard.nextLine();
        if (guess.length() == 0) {
            return false;
        }
        if (guesses.contains(guess.charAt(0))) {
            System.out.println("Already entered " + guess.charAt(0));
            return false;
        }
        guesses.add(guess.charAt(0));
        return true;

    }

    private static int printState(String word, List<Character> guesses) {
        int numCorrect = 0;
        for (int i = 0; i < word.length(); i++) {
            if (guesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                numCorrect++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println(" \t\t Already guessed " + guesses);
        System.out.println();
        return numCorrect;
    }
    
}
