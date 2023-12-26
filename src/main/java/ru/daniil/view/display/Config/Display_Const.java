package ru.daniil.view.display.Config;


public class Display_Const {
    protected static final int X_POINT = 0;
    protected static final int Y_POINT = 1;
    protected static String NEXT_COMMAND;
    protected static int[] NEXT_COMMAND_location;
    protected static String logo_image;
    protected static String logo_text;

    public static String DEFAULT_HIDDEN_WORD;

    public static String symbolLetterNoNeed = "-";
    public static String symbolLetterNeed = "✓";
    public static String symbolLetterWrongPlace = "?";
    protected static String symbol_frame_x;
    protected static String symbol_frame_y;
    protected static String symbol_for_lineFilling;

    protected static int SIZE_DISPLAY_X;
    protected static int SIZE_DISPLAY_Y;

    protected static int location_Y_headline;

    protected static int[] textBlock_TITLE_location_Y = new int[1];
    protected static int[] textBlock_NOTIFICATION_location_Y = new int[2];
    protected static int[] textBlock_CONTENT_location_Y = new int[4];
    protected static int messages_position_X;
    public static int messageLines_size;


    protected void set_Next_Command(String nextCommand) {
        NEXT_COMMAND = nextCommand;
    }

    static {
        set_logo();
        set_appValues();
        set_displayValues();
    }

    private static void set_appValues() {
        SIZE_DISPLAY_X = 30;
        SIZE_DISPLAY_Y = 21;

        DEFAULT_HIDDEN_WORD = "[][][][][]";
        symbol_frame_x = "_";
        symbol_frame_y = "|";
        symbol_for_lineFilling = "-";
        NEXT_COMMAND_location = new int[]{1, SIZE_DISPLAY_Y - 1};
    }

    /**
     * <h3>I don’t specify the Y coordinate for:</h3>
     * <pre>
     *     location_X_line_TITLE
     *     location_X_line_NOTIFICATION
     *     location_X_line_CONTENT
     * </pre>
     * because when adding text to the screen
     * centering occurs relative to the text content
     * <pre></pre>
     * <h3>Full X, Y coordinates to add server IP and server PORT</h3>
     */
    private static void set_displayValues() {
        location_Y_headline = 1;

        textBlock_TITLE_location_Y[0] = 4;

        textBlock_NOTIFICATION_location_Y[0] = 5;
        textBlock_NOTIFICATION_location_Y[1] = 6;

        textBlock_CONTENT_location_Y[0] = 8;
        textBlock_CONTENT_location_Y[1] = 9;
        textBlock_CONTENT_location_Y[2] = 10;
        textBlock_CONTENT_location_Y[3] = 11;

        messages_position_X = 3;
        messageLines_size = (SIZE_DISPLAY_Y - 2) - (textBlock_NOTIFICATION_location_Y[1] + 1);
    }

    private static void set_logo() {
        logo_image =
                "⠀     ⠀        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣿⣿⣿⣶⣶⣤⣄⡀⠀⠀⠀⠀⠀\n" +
                        "⠀  ⠀⠀         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣯⢿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣦⠀⠀⠀⠀\n" +
                        "⠀      ⠀     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣯⣽⣶⣶⣾⣕⣝⣧⣣⢫⡋⡿⠿⣇⠀⠀⠀\n" +
                        "⠀         ⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⢖⢬⣍⠻⣿⣿⡜⢧⠑⣴⣿⣿⣦⠀⠀\n" +
                        "  ⠀      ⠀   ⠐⠻⣿⣿⣟⣛⡻⠶⣦⣻⣿⣿⣿⣿⡗⢿⣿⣿⢙⠛⣃⠬⢄⠉⠉⠀⠀⠀⠀\n" +
                        "⠀         ⠀⠀  ⠀⠈⠻⣿⣿⠁⠀⣶⣿⣿⣿⣿⣿⣏⣚⣏⣴⢟⣟⠁⣰⠀⡇⣄⣽⣿⡄⠀\n" +
                        "⠀⠀         ⠀⠀⠀  ⠀⠈⢿⣶⡾⠿⢻⣿⣿⡛⠋⠁⣠⢏⣵⣿⣿⣿⣿⣷⣿⡘⡜⡿⠃⠀\n" +
                        "         ⠀⠀⠀⠀⠀⠀⠀  ⠀⠙⠿⣿⡿⣿⢻⡧⢀⡞⣡⣿⣿⣿⣿⣿⣿⣿⡿⣷⢁⠀⠀⠀\n" +
                        "       ⠀  ⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⣾⡿⣼⣳⢿⣾⣿⣿⣿⣶⣶⣶⣶⡶⠶⣶⣍ \n" +
                        "⠀       ⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀  ⣿⢷⣿⣿⣿⡿⢋⠀⢶⠂⠶⠀⠄⠄⡤⣤  \n" +
                        " ⠀        ⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⢸⣿⠈⣿⣿⠟⠀⣰⡇⢀⡀⠀⠠⠀⠀⠀⠉⣤  \n" +
                        "    ⠀  ⠀       ⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇⠼⠷⢿⣇⢸⣷⡀⣾⡆⣾⣷⠠⡿⠆ \n" +
                        "       ⠀⠀ ⠀   ⠀⠀⠀⠀⠀⠀⠀⠸⣿⣽⣿⣷⣿⡿⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣶⣷⣦ \n" +
                        "       ⠀⠀⠀⠀  ⠀  ⠀⠀⠀⠀⠀⠀⠙⠛⠛⣿⣿⣿⣶⣤⣤⣈⡉⠉⠉⠉⠉⠉⠉⠉⠁⠀\n" +
                        "       ⠀⠀⠀⠀⠀⠀  ⠀⠀  ⠀⠀⠀⠀⠀⠀⠈⠻⣯⣭⣯⣭⣤⣶⣶⣶⣶⣦⣤⡈⠁⠀⠀\n" +
                        "       ⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀  ⠀⠀⠀⠀⠀⠈⠛⠛⠿⠛⠛⠁⠈⠉⠙⠛⠁⠀⠀";
        logo_text =
                "         _      _                  ____                    _             \n" +
                        "        | |    (_) _ __    ___    / ___|   ___  _ __    __| |  ___  _ __ \n" +
                        "        | |    | || '_ \\  / _ \\   \\___ \\  / _ \\| '_ \\  / _` | / _ \\| '__|\n" +
                        "        | |___ | || | | ||  __/    ___) ||  __/| | | || (_| ||  __/| |   \n" +
                        "        |_____||_||_| |_| \\___|   |____/  \\___||_| |_| \\__,_| \\___||_|   ";
    }

    protected static int get_X_for_centering(String str) {
        return get_X_centerDisplay() - (Math.round((float) str.length() / 2));
    }

    protected static int get_X_centerDisplay() {
        return (SIZE_DISPLAY_X / 2);
    }

    /**
     * <h3>Fills the resulting row at the edges</h3>
     * The input string is in the middle
     *
     * @param str String
     * @return String
     */
    private static String filledLine(String str) {
        int str_startsWIth = get_X_for_centering(str);
        StringBuilder filled_string = new StringBuilder();

        for (int i = 0; i < str_startsWIth - 1; i++) {
            filled_string.append(symbol_for_lineFilling);
        }
        filled_string.append(str);
        for (int i = str_startsWIth + str.length(); i < SIZE_DISPLAY_X - 1; i++) {
            filled_string.append(symbol_for_lineFilling);
        }
        return filled_string.toString();
    }

}