package ru.daniil.app;

import ru.daniil.display.Config.Blocks_Text;
import ru.daniil.display.User_Display;
import ru.daniil.display.Config.Display_Const;

import java.util.Arrays;
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
    private static String wordThatNeedToGuess;
    private static String[] arrayWordThatNeedToGuess;


    public static void main(String[] args) {
        display.initDisplay();
        display.update("Enter the word for guess: ");
        display.show(true);

        wordThatNeedToGuess = APP.getInput();
        arrayWordThatNeedToGuess = wordThatNeedToGuess.split("");

        display.update("You have " + Display_Const.attemptsCount + " attempts :D");
        display.add(Display_Const.DEFAULT_HIDDEN_WORD, Blocks_Text.HIDDEN_WORD);
        display.show(true);

        runGame();
    }

    private static void runGame() {
        String suggestedWord;
        Display_Const.setAttemptsCount();

        while (true) {
            if (Display_Const.attemptsCount == 0) {
                // TODO user is lose
            }

            suggestedWord = APP.getInput();
            if (suggestedWord.equals(wordThatNeedToGuess)) {
                // TODO user is WIN
            }

            String[] letterCondition = analyzeLetter(suggestedWord);
            Display_Const.attemptsCount--;

            display.add(suggestedWord, letterCondition);
            display.show(false);
        }
    }

    private static String[] analyzeLetter(String suggestedWord) {
        String[] arraySuggestedWord = suggestedWord.split("");
        String[] resultOfChecking = new String[arrayWordThatNeedToGuess.length];

        for (int i = 0; i < arraySuggestedWord.length; i++) {
            if (arraySuggestedWord[i].equals(arrayWordThatNeedToGuess[i])) {
                resultOfChecking[i] = User_Display.symbolLetterNeed;
            } else if (wordThatNeedToGuess.indexOf(arraySuggestedWord[i]) > 0) {
                resultOfChecking[i] = Display_Const.symbolLetterWrongPlace;
            } else {
                resultOfChecking[i] = Display_Const.symbolLetterNoNeed;
            }
        }

        return resultOfChecking;
    }
}
