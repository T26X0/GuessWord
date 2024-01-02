package ru.daniil.tud.Config;


import java.util.HashMap;
import java.util.Map;

public class DisplayConst {
    protected static final int X_POINT = 0;
    protected static final int Y_POINT = 1;
    protected static final int NOT_CHANGED = -1;
    protected static final int DEFAULT_LINE_INDEX = -1;
    protected static int sizeDisplayX;
    protected static int sizeDisplayY;
    protected static String appName;
    protected static boolean appInDebugUse;
    protected static String nextCommandForUser;
    protected static int[] nextCommandForUserLocation;
    protected static String logo_image =
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

    protected static String symbol_frame_x = "_";
    protected static String symbol_frame_y = "|";

    protected static int headlineLocationY = 2;

    protected static Map<Integer, Boolean> titleTextBlockCondition = new HashMap<>();
    protected static int[] positionTitleTextBlockHeight = new int[2];

    protected static Map<Integer, Boolean> notificationTextBlockCondition = new HashMap<>();
    protected static int[] positionNotificationTextBlockHeight = new int[2];

    protected static Map<Integer, Boolean> contentTextBlockCondition = new HashMap<>();
    protected static int[] positionContentTextBlockHeight = new int[sizeDisplayY];
    protected static int contentTextBlockSize = 4;

    static {
        sizeDisplayX = 45;
        sizeDisplayY = 26;

        initTextBlocks();
    }

    public void setNextCommand(String nextCommand) {
        nextCommandForUser = nextCommand;
    }

    protected static TextBlocks getTextBlockByCoordinate(int coordinateY) {
        for (int value : positionTitleTextBlockHeight) {
            if (value == coordinateY) {
                return TextBlocks.TITLE;
            }
        }

        for (int value : positionNotificationTextBlockHeight) {
            if (value == coordinateY) {
                return TextBlocks.NOTIFICATION;
            }
        }

        for (int value : positionContentTextBlockHeight) {
            if (value == coordinateY) {
                return TextBlocks.CONTENT;
            }
        }
        return TextBlocks.VOID;
    }

    protected static void initTextBlocks() {
        positionTitleTextBlockHeight[0] = 4;
        positionTitleTextBlockHeight[1] = positionTitleTextBlockHeight[0] + 1;

        positionNotificationTextBlockHeight[0] = positionTitleTextBlockHeight[1] + 2;
        positionNotificationTextBlockHeight[1] = positionNotificationTextBlockHeight[0] + 1;

        contentTextBlockSize = (sizeDisplayY - 2) - (positionNotificationTextBlockHeight[1] + 2);
        positionContentTextBlockHeight = new int[contentTextBlockSize];
        initContentTextBlock();
        resetTextBlockBusy();
    }

    private static void initContentTextBlock() {
        int startLineIndexForContentBlock = positionNotificationTextBlockHeight[1] + 2;

        positionContentTextBlockHeight = new int[contentTextBlockSize];

        for (int i = 0; i < contentTextBlockSize; i++) {
            positionContentTextBlockHeight[i] = startLineIndexForContentBlock;
            startLineIndexForContentBlock += 1;
        }

    }

    protected static void resetTextBlockBusy() {
        contentTextBlockCondition = new HashMap<>();
        for (Integer integer : positionTitleTextBlockHeight) {
            titleTextBlockCondition.put(integer, false);
        }

        for (Integer integer : positionNotificationTextBlockHeight) {
            notificationTextBlockCondition.put(integer, false);
        }

        for (Integer integer : positionContentTextBlockHeight) {
            contentTextBlockCondition.put(integer, false);
        }
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
    protected static int get_X_for_centering(String str) {
        return get_X_centerDisplay() - (Math.round((float) str.length() / 2));
    }

    protected static int get_X_centerDisplay() {
        return (sizeDisplayX / 2);
    }
}
