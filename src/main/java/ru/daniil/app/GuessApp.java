package ru.daniil.app;

import ru.daniil.tud.Config.CenterMod;
import ru.daniil.tud.Config.TextBlocks;
import ru.daniil.tud.MyException.TextBlockFilledException;
import ru.daniil.tud.UserDisplay;

import java.util.*;

public class GuessApp {

    private final Scanner input;
    private final String DEFAULT_HIDDEN_LETTER = "[]";
    private final String symbolLetterNoNeed = "-";
    private final String symbolLetterWrongPlace = "?";
    private final String symbolLetterNeed = "+";
    private int attemptsCount;
    private final int appWidth = 65;
    private final int appHeight = 30;
    private final UserDisplay display = new UserDisplay(appWidth, appHeight, true);
    private String wordThatNeedToGuess;
    private String[] letterArrayFromWordThatNeedToGuess;
    private Map<String, String> allNeedLetters = new HashMap<>();
    GameUtils gameUtils = new GameUtils();

    public GuessApp() throws TextBlockFilledException {
        input = new Scanner(System.in);
        gameUtils.addHorizontalLineInDisplay();
    }

    public static void main(String[] args) throws TextBlockFilledException {
        GuessApp game = new GuessApp();
        game.startNewGame();
    }

    /**
     * Game entry point
     */
    public void startNewGame() throws TextBlockFilledException {
        attemptsCount = 5;
        setInventedWord();
        cycleGuessWord();
    }

    private String getInput() {
        return input.nextLine().trim();
    }

    /**
     * The first user comes up with a word for further guessing
     */
    private void setInventedWord() throws TextBlockFilledException {

        String userWord;
        display.resetAllDisplay();

        while (true) {
            display.add("Enter the word for guess: ", TextBlocks.NOTIFICATION, 0, CenterMod.MID);
            gameUtils.updateAndShowDisplay();

            userWord = getInput();
            letterArrayFromWordThatNeedToGuess = userWord.split("");
            if (gameUtils.isValidWord(userWord)) {
                wordThatNeedToGuess = userWord;
                break;
            }
            display.add("is not corrected word", TextBlocks.CONTENT, 0, CenterMod.MID);
        }
    }

    /**
     * The main stage of the game in which the player tries to guess the word
     */
    private void cycleGuessWord() throws TextBlockFilledException {
        String guessWord = "";

        display.resetAllDisplay();
        /*
         * Creating a line for "basic cap"
         */
        for (int i = 0; i < wordThatNeedToGuess.length(); i++) {
            guessWord += DEFAULT_HIDDEN_LETTER;
        }
        gameUtils.addBasicCapForApp(guessWord);

        /*
         * Main loop of word guessing
         */
        display.setNextCommand("You have " + attemptsCount + " attempts :D");
        gameUtils.updateAndShowDisplay();
        while (true) {
            if (attemptsCount == 0) {
                display.resetAllDisplay();
                choiceOfGameContinuation();
            }

            String suggestedWord;
            suggestedWord = getInput();
            char[] allLettersFromSuggestedWord = suggestedWord.toCharArray();
            if (suggestedWord.equals(wordThatNeedToGuess)) {
                congratulation();
            } else {
                if (suggestedWord.length() == wordThatNeedToGuess.length()) {
                    attemptsCount--;

                    String[] letterCondition = gameUtils.analyzeLetter(suggestedWord);
                    display.setNextCommand("You have " + attemptsCount + " attempts :D    ");
                    display.add(Arrays.toString(allLettersFromSuggestedWord), TextBlocks.CONTENT, CenterMod.MID);
                    display.add(Arrays.toString(letterCondition), TextBlocks.CONTENT, CenterMod.MID);
                }
                gameUtils.updateAndShowDisplay();
            }
        }
    }

    private void congratulation() throws TextBlockFilledException {
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
        gameUtils.exitFromGame();
    }

    /**
     * The user gets here after losing
     * and chooses where to move next
     */
    private void choiceOfGameContinuation() throws TextBlockFilledException {
        String userAnswer;

        display.add("OUT OF LUCK THIS TIME", TextBlocks.NOTIFICATION, CenterMod.MID);
        display.add("TRY AGAIN OR KEEP GUESSING THIS WORD", TextBlocks.NOTIFICATION, CenterMod.MID);
        display.add("1. -> start new game (and new word)", TextBlocks.CONTENT, CenterMod.MID);
        display.add("2. -> show guess word", TextBlocks.CONTENT, CenterMod.MID);
        display.add("3. -> get 5 more tries", TextBlocks.CONTENT, CenterMod.MID);
        gameUtils.updateAndShowDisplay();
        userAnswer = getInput();

        switch (userAnswer) {
            case "1" -> {
                allNeedLetters = new HashMap<>();
                startNewGame();
            }
            case "2" -> {
                allNeedLetters = new HashMap<>();
                showGuessWord();
            }
            case "3" -> {
                allNeedLetters = new HashMap<>();
                continueGameWithNewTries();
            }
            default -> {
                allNeedLetters = new HashMap<>();
                display.resetAllDisplay();
                display.add("...there is no such answer...", TextBlocks.TITLE, CenterMod.MID);
                display.add("...try again...", TextBlocks.TITLE, CenterMod.MID);
                choiceOfGameContinuation();
            }
        }
    }

    private void showGuessWord() throws TextBlockFilledException {
        display.resetRequiredFields();
        display.resetAllDisplay();
        wordThatNeedToGuess = gameUtils.insertLettersInBrackets(wordThatNeedToGuess);
        gameUtils.addBasicCapForApp(wordThatNeedToGuess);
        gameUtils.updateAndShowDisplay();
        gameUtils.exitFromGame();
    }

    private void continueGameWithNewTries() throws TextBlockFilledException {
        attemptsCount = 5;
        cycleGuessWord();
    }

    class GameUtils {
        private void updateAndShowDisplay() throws TextBlockFilledException {
            addAllLettersWithTheirCondition();
            display.update().show();
        }

        private void addHorizontalLineInDisplay() throws TextBlockFilledException {
            String horizontalLine = "";

            for (int i = 0; i < appWidth; i++) {
                horizontalLine += "_";
            }
            display.addRequiredField(horizontalLine, TextBlocks.CONTENT, 11, CenterMod.MID);
        }

        private void addBasicCapForApp(String hiddenWord) throws TextBlockFilledException {
            display.add("You need to guess word that invented another user:", TextBlocks.TITLE, 0, CenterMod.MID);
            display.add(hiddenWord, TextBlocks.TITLE, 1, CenterMod.MID);
        }

        private void addAllLettersWithTheirCondition() throws TextBlockFilledException {
            int lastLineIndex = 12;
            String line = "";
            int letterCount = 0;

            List<String> allKeys = new ArrayList<>(allNeedLetters.keySet());
            for (String key : allKeys) {
                if (appWidth - letterCount >= 10) {
                    line += key + " " + allNeedLetters.get(key) + ", ";
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

        private String insertLettersInBrackets(String wordThatNeedToGuess) {
            char[] allLetters = wordThatNeedToGuess.toCharArray();

            return Arrays.toString(allLetters);
        }

        private boolean isValidWord(String userWord) {
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

        private String[] analyzeLetter(String suggestedWord) {
            String[] arraySuggestedLetters = suggestedWord.split("");
            String[] resultOfChecking = new String[letterArrayFromWordThatNeedToGuess.length];

            for (int i = 0; i < arraySuggestedLetters.length; i++) {
                if (arraySuggestedLetters[i].equals(letterArrayFromWordThatNeedToGuess[i])) {
                    resultOfChecking[i] = symbolLetterNeed;
                    allNeedLetters.put(arraySuggestedLetters[i], symbolLetterNeed);
                } else if (wordThatNeedToGuess.indexOf(arraySuggestedLetters[i]) > 0) {
                    resultOfChecking[i] = symbolLetterWrongPlace;
                    allNeedLetters.put(arraySuggestedLetters[i], symbolLetterNeed);
                } else {
                    resultOfChecking[i] = symbolLetterNoNeed;
                }
            }

            return resultOfChecking;
        }

        private void exitFromGame() {
            System.exit(0);
        }
    }
}
