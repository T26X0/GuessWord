package ru.daniil.display;


import ru.daniil.display.Config.Blocks_Text;
import ru.daniil.display.Config.Display_Config;

import java.util.Arrays;
import java.util.Map;

/**
 * <h2>Class for visualization client actions</h2>
 * Size:
 * <pre>x = 30</pre>
 * <pre>y = 30</pre>
 */
public class User_Display extends Display_Config {

    public User_Display() {
        super();
    }

    public void initDisplay() {
        init();
    }

    public void add(String suggestWord, String[] suggestWordResult) {
        System.out.println(suggestWord + lineCounter);
        add(suggestWord, Blocks_Text.SUGGEST_WORD);
        lineCounter--;
        add(Arrays.toString(suggestWordResult), Blocks_Text.SUGGEST_WORD_RESULT);
    }

    public void add(String str, Blocks_Text textBlock) {
        int x = get_X_for_centering(str);
        int y = 0;

        Map<String, String> stringWithCoordinates;

        if (textBlock == Blocks_Text.HIDDEN_WORD) {

            y = Blocks_Text.HIDDEN_WORD.coordinates[lineCounter];
        }

        if (textBlock == Blocks_Text.SUGGEST_WORD) {

            y = Blocks_Text.SUGGEST_WORD.coordinates[lineCounter];
        }

        if (textBlock == Blocks_Text.SUGGEST_WORD_RESULT) {

            y = Blocks_Text.SUGGEST_WORD_RESULT.coordinates[lineCounter];
        }

        if (textBlock == Blocks_Text.SUGGEST_WORD_RESULT) {

            y = Blocks_Text.SUGGEST_WORD_RESULT.coordinates[lineCounter];
        }

        if (textBlock == Blocks_Text.NOTIFICATION) {

            y = Blocks_Text.NOTIFICATION.coordinates[lineCounter];
        }

        if (textBlock == Blocks_Text.CONTENT) {
            System.out.println(str);
            y = Blocks_Text.CONTENT.coordinates[lineCounter];
        }

        stringWithCoordinates = prepareToInsertInMap(x, y, str);
        addToDisplay(stringWithCoordinates);
        lineCounter++;
    }

    /**
     * <h3>reset display -> deleting all text block</h3>
     * <pre>
     *     1. TextBlock.TITLE
     *     2. TextBlock.NOTIFICATION
     *     3. TextBlock.CONTENT
     * </pre>
     */
    public void update() {
        updateDisplay();
    }

    public void update(String nextCommand) {
        set_Next_Command(nextCommand);
        updateDisplay();
    }

    public void show(boolean resetLineCounter) {
        purify_display();
        show_display();
        if (resetLineCounter) {
            resetLineCounter();
        }
    }

    public void setNewLetter(String letter) {
        // TODO
    }
}
