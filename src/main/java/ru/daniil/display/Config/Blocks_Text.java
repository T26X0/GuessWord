package ru.daniil.display.Config;


public enum Blocks_Text {

    /**
     * Provides ONE LINE for HIDDEN block
     */
    HIDDEN_WORD(Display_Const.textBlock_HIDDEN_WORD_location_Y),

    /**
     * Provides FIVE LINE for SUGGEST block
     */
    SUGGEST_WORD(Display_Const.textBlock_SUGGEST_WORD_location_Y),

    /**
     * Provides FIVE LINE for SUGGEST block
     */
    SUGGEST_WORD_RESULT(Display_Const.textBlock_SUGGEST_WORD_RESULT_location_Y),

    /**
     * Provides TWO LINES for NOTIFICATION block
     */
    NOTIFICATION(Display_Const.textBlock_NOTIFICATION_location_Y),

    /**
     * Provides FOUR LINES for CONTEXT block
     */
    CONTENT(Display_Const.textBlock_CONTENT_location_Y);

    public final int[] coordinates;

    Blocks_Text(int[] lines) {
        this.coordinates = lines;
    }
}
