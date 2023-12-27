package ru.daniil.app;

import ru.daniil.display.Config.Blocks_Text;
import ru.daniil.display.User_Display;
import ru.daniil.display.Config.Display_Const;

import java.util.Scanner;

public class GuessApp {

    private final Scanner input;

    public GuessApp() {
        input = new Scanner(System.in);
    }

    public String getInput() {
        return input.nextLine().trim();
    }
}

class Begin {

    private static final GuessApp APP = new GuessApp();
    private static final User_Display display = new User_Display();
    private static int attemptsCount = 5;
    private static String wordThatNeedToGuess;
    private static String[] arrayWordThatNeedToGuess;


    public static void main(String[] args) {
        display.initDisplay();
        display.update("Enter the word for guess: ");
        display.show();

        wordThatNeedToGuess = APP.getInput();
        arrayWordThatNeedToGuess = wordThatNeedToGuess.split("");

        System.out.println(wordThatNeedToGuess);

        display.update("You have " + attemptsCount + " attempts :D");
        display.add(Display_Const.DEFAULT_HIDDEN_WORD, Blocks_Text.HIDDEN_WORD);
        display.show();

        runGame();
//        System.out.println("You need to guess word that invented another user");
//        System.out.println("You have five attempts!!!");
//        System.out.println("Good luck :D");


    }

    private static void runGame() {
        String suggestedWord;

        while (true) {
            if (attemptsCount == 0) {
                // TODO user is lose
            }

            suggestedWord = APP.getInput();
            if (suggestedWord.equals(wordThatNeedToGuess)) {
                // TODO user is WIN
            }

            String[] letterCondition = analyzeLetter(suggestedWord);

            attemptsCount--;
        }
    }

    private static String[] analyzeLetter(String suggestedWord) {
        String[] arraySuggestedWord = suggestedWord.split("");
        String[] resultOfChecking = new String[arrayWordThatNeedToGuess.length];

        for (int i = 0; i < arraySuggestedWord.length; i++) {
            if (arraySuggestedWord[i].equals(arrayWordThatNeedToGuess[i])) {
                resultOfChecking[i] = User_Display.symbolLetterNeed;
            }
            if (wordThatNeedToGuess.indexOf(arraySuggestedWord[i]) > 0) {
                resultOfChecking[i] = Display_Const.symbolLetterWrongPlace;
            }
        }

        return resultOfChecking;
    }
}
