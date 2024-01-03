package ru.daniil.TerminalUserInterface;


import ru.daniil.TerminalUserInterface.Config.CenterMod;
import ru.daniil.TerminalUserInterface.Config.DisplayConst;
import ru.daniil.TerminalUserInterface.Config.TextBlocks;
import ru.daniil.TerminalUserInterface.Config.DisplayConfig;
import ru.daniil.TerminalUserInterface.MyException.TextBlockFilledException;

public class UserDisplay extends DisplayConfig {

    /**
     * <pre>Minimal values for app size:
     *      x > 45,
     *      y > 16.</pre>
     * <pre> :
     *      x > 60,
     *      y > 23.</pre>
     */
    public UserDisplay(int x, int y, boolean debug) {
        DisplayConst.appInDebugUse = debug;
        showLogo();

        sizeDisplayX = x;
        sizeDisplayY = y;
        initTextBlocks();

        appName = " ";
        initDisplayFrames();
    }

    public void setAppName(String title) {

        appName = title;
        addAppName();
    }

    public void show() {
        purifyTerminal();
        addRequiredElementsToDisplay();
        showAllDisplay();
    }

    public UserDisplay resetRequiredFields() {
        resetRequiresFieldsFromDisplay();
        return this;
    }

    public UserDisplay update() {
        updateDisplay();
        return this;
    }

    public void addRequiredField(String str, TextBlocks textBlock, CenterMod inCenter)
            throws TextBlockFilledException {
        addNewElementsInRequiredAppField(str, textBlock, inCenter);
    }

    public void addRequiredField(String str, TextBlocks textBlock, int textLineIndex, CenterMod inCenter)
            throws TextBlockFilledException {
        addNewElementsInRequiredAppField(str, textBlock, textLineIndex, inCenter);
    }

    public void add(String str, TextBlocks textBlock, CenterMod inCenter) throws TextBlockFilledException {
        addNewElement(str, textBlock, inCenter);
    }
    public void add(String str, TextBlocks textBlock, int lineIndex, CenterMod inCenter) throws TextBlockFilledException {
        addNewElement(str, textBlock, lineIndex, inCenter);
    }
}
