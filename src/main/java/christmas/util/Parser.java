package christmas.util;

import static christmas.constant.InputConstant.*;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    public static List<String> separateBySeparator(String input, String separator) {
        return Arrays.asList(input.split(separator));
    }

    public static int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String replaceUnderbar(String input) {
        return input.replaceAll(UNDERBAR.getContent(), BLANK.getContent());
    }
}
