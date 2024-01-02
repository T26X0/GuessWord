package ru.daniil.app;

import ru.daniil.tud.Config.CenterMod;
import ru.daniil.tud.Config.TextBlocks;
import ru.daniil.tud.MyException.TextBlockFilledException;
import ru.daniil.tud.UserDisplay;

import java.util.*;

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
    private static final String DEFAULT_HIDDEN_LETTER = "[]";
    private static final String symbolLetterNoNeed = "-";
    private static final String symbolLetterWrongPlace = "?";
    private static final String symbolLetterNeed = "+";
    private static int attemptsCount = 5;
    private static final int appWidth = 65;
    private static final int appHeight = 30;
    private static final UserDisplay display = new UserDisplay(appWidth, appHeight, true);
    private static String wordThatNeedToGuess;
    private static String[] arrayWordThatNeedToGuess;
    private static Map<String, String> allLetters = new HashMap<>();

    public static void main(String[] args) throws TextBlockFilledException {
        addHorizontalLineInDisplay();
        startNewGame();
    }

    private static void addHorizontalLineInDisplay() throws TextBlockFilledException {
        String horizontalLine = "";

        for (int i = 0; i < appWidth; i++) {
            horizontalLine += "_";
        }
        display.addRequiredField(horizontalLine, TextBlocks.CONTENT, 11, CenterMod.MID);
    }

    private static void addAllLettersWithTheirCondition() throws TextBlockFilledException {
        int lastLineIndex = 12;
        String line = "";
        int letterCount = 0;

        List<String> allKeys = new ArrayList<>(allLetters.keySet());
        for (String key : allKeys) {
            if (appWidth - letterCount >= 10) {
                line += key + " " + allLetters.get(key) + ", ";
                letterCount += 6;
            } else {
                display.addRequiredField(line, TextBlocks.CONTENT, 12, CenterMod.MID);
                line = "";
                letterCount = 0;
                lastLineIndex++;
            }
        }

        if (!line.isEmpty()) {
            display.addRequiredField(line, TextBlocks.CONTENT, 12, CenterMod.MID);
        }
    }

    private static void startNewGame() throws TextBlockFilledException {
        attemptsCount = 5;
        wordThatNeedToGuess = getInventedWord();

        cycleGuessWord();
    }

    private static void addBasicCapForApp(String hiddenWord) throws TextBlockFilledException {
        display.add("You need to guess word that invented another user:", TextBlocks.TITLE, 0, CenterMod.MID);
        display.add(hiddenWord, TextBlocks.TITLE, 1, CenterMod.MID);
    }

    private static String getInventedWord() throws TextBlockFilledException {

        String userWord;
        display.resetAllDisplay();

        while (true) {
            display.add("Enter the word for guess: ", TextBlocks.NOTIFICATION, 0, CenterMod.MID);
            updateAndShowDisplay();

            userWord = APP.getInput();
            arrayWordThatNeedToGuess = userWord.split("");
            if (isValidWord(userWord)) {
                return userWord;
            } else {
                display.add("is not corrected word", TextBlocks.CONTENT, 0, CenterMod.MID);
            }
        }
    }

    private static void cycleGuessWord() throws TextBlockFilledException {
        String suggestedWord;
        String guessWord = "";
        for (int i = 0; i < wordThatNeedToGuess.length(); i++) {
            guessWord += DEFAULT_HIDDEN_LETTER;
        }

        display.resetAllDisplay();

        addBasicCapForApp(guessWord);
        display.setNextCommand("You have " + attemptsCount + " attempts :D");
        updateAndShowDisplay();

        while (true) {
            if (attemptsCount == 0) {
                display.resetAllDisplay();
                choiceOfGameContinuation();
            }

            suggestedWord = APP.getInput();
            char[] allLettersFromSuggestedWord = suggestedWord.toCharArray();
            if (suggestedWord.equals(wordThatNeedToGuess)) {
                congratulation();
            } else {
                if (suggestedWord.length() == wordThatNeedToGuess.length()) {
                    String[] letterCondition = analyzeLetter(suggestedWord);
                    attemptsCount--;

                    display.setNextCommand("You have " + attemptsCount + " attempts :D    ");
                    display.add(Arrays.toString(allLettersFromSuggestedWord), TextBlocks.CONTENT, CenterMod.MID);
                    display.add(Arrays.toString(letterCondition), TextBlocks.CONTENT, CenterMod.MID);
                }
                updateAndShowDisplay();
            }
        }
    }

    private static void congratulation() throws TextBlockFilledException {
        display.resetRequiredFields();
        display.resetAllDisplay();
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.add("YOU ARE WIN", TextBlocks.CONTENT, CenterMod.MID);
        display.update().show();
    }

    private static String[] analyzeLetter(String suggestedWord) {
        String[] arraySuggestedLetters = suggestedWord.split("");
        String[] resultOfChecking = new String[arrayWordThatNeedToGuess.length];

        for (int i = 0; i < arraySuggestedLetters.length; i++) {
            if (arraySuggestedLetters[i].equals(arrayWordThatNeedToGuess[i])) {
                resultOfChecking[i] = symbolLetterNeed;
                allLetters.put(arraySuggestedLetters[i], symbolLetterNeed);
            } else if (wordThatNeedToGuess.indexOf(arraySuggestedLetters[i]) > 0) {
                resultOfChecking[i] = symbolLetterWrongPlace;
                allLetters.put(arraySuggestedLetters[i], symbolLetterNeed);
            } else {
                resultOfChecking[i] = symbolLetterNoNeed;
            }
        }

        return resultOfChecking;
    }

    private static boolean isValidWord(String userWord) {
        String[] notCorrectSymbols = new String[]{
                ",", ".", "/", "<", ">", "?", "\"", "\\", "|", ".", ",", "/",
                "!", "№", ";", "%", ":", "*", "(", ")", "_", "+", "=", "-"};
        int index = -1;

        for (String symbol : notCorrectSymbols) {
            if (index != -1) {
                return false;
            }
            index = userWord.indexOf(symbol);
        }
        return true;
    }

    private static void choiceOfGameContinuation() throws TextBlockFilledException {
        String userAnswer;

        display.add("OUT OF LUCK THIS TIME", TextBlocks.NOTIFICATION, CenterMod.MID);
        display.add("TRY AGAIN OR KEEP GUESSING THIS WORD", TextBlocks.NOTIFICATION, CenterMod.MID);
        display.add("1. -> start new game (and new word)", TextBlocks.CONTENT, CenterMod.MID);
        display.add("2. -> show guess word", TextBlocks.CONTENT, CenterMod.MID);
        display.add("3. -> get 5 more tries", TextBlocks.CONTENT, CenterMod.MID);
        updateAndShowDisplay();
        userAnswer = APP.getInput();

        switch (userAnswer) {
            case "1" -> {
                allLetters = new HashMap<>();
                startNewGame();
            }
            case "2" -> {
                allLetters = new HashMap<>();
                showGuessWord();
            }
            case "3" -> {
                allLetters = new HashMap<>();
                continueGameWithNewTries();
            }
            default -> {
                allLetters = new HashMap<>();
                display.resetAllDisplay();
                display.add("...there is no such answer...", TextBlocks.TITLE, CenterMod.MID);
                display.add("...try again...", TextBlocks.TITLE, CenterMod.MID);
                choiceOfGameContinuation();
            }
        }
    }

    private static void showGuessWord() throws TextBlockFilledException {
        display.resetRequiredFields();
        display.resetAllDisplay();
        wordThatNeedToGuess = insertLettersInBrackets(wordThatNeedToGuess);
        addBasicCapForApp(wordThatNeedToGuess);
        updateAndShowDisplay();
    }

    private static String insertLettersInBrackets(String wordThatNeedToGuess) {
        char[] allLetters = wordThatNeedToGuess.toCharArray();

        return Arrays.toString(allLetters);
    }

    private static void continueGameWithNewTries() throws TextBlockFilledException {
        attemptsCount = 5;
        cycleGuessWord();
    }

    private static void updateAndShowDisplay() throws TextBlockFilledException {
        addAllLettersWithTheirCondition();
        display.update().show();
    }
}
