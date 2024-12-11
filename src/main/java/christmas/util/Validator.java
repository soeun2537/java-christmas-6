package christmas.util;

import static christmas.constant.InputConstant.*;
import static christmas.constant.message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private Validator() {
    }

    public static void validateVisitDateBeforeParsing(String input) {
        validateNotNull(input, INVALID_DATE_FORMAT.getMessage());
        validateNumeric(input, INVALID_DATE_FORMAT.getMessage());

    }

    public static void validateVisitDateAfterParsing(int input) {
        validateRange(input, 1, 31, INVALID_DATE_FORMAT.getMessage());
    }

    public static void validateMenuBeforeParsing(String input) {
        validateNotNull(input, INVALID_MENU_FORMAT.getMessage());
    }

    public static void validateMenuName(String input) {
        validateNotNull(input, INVALID_MENU_FORMAT.getMessage());
        validateCharacter(input, INVALID_MENU_FORMAT.getMessage());
    }

    public static void validateMenuNames(List<String> inputs) {
        validateDuplicate(inputs, INVALID_MENU_FORMAT.getMessage());
    }

    public static void validateMenuCount(String input) {
        validateNotNull(input, INVALID_MENU_FORMAT.getMessage());
        validateNumeric(input, INVALID_MENU_FORMAT.getMessage());
    }

    public static void validateMenuCounts(List<Integer> inputs) {
        for (Integer input : inputs) {
            validateNonNegative(input, INVALID_MENU_FORMAT.getMessage());
            validateNotZero(input, INVALID_MENU_FORMAT.getMessage());
        }
    }

    private static void validateNotNull(String input, String errorMessage) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateNumeric(String input, String errorMessage) {
        if (!input.matches(NUMERIC_PATTERN.getContent())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateRange(int input, int min, int max, String errorMessage) {
        if (input < min || input > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateCharacter(String input, String errorMessage) {
        if (!input.matches(CHARACTER_PATTERN.getContent())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateDuplicate(List<String> inputs, String errorMessage) {
        List<String> uniqueInputs = new ArrayList<>();
        for (String input : inputs) {
            if (uniqueInputs.contains(input)) {
                throw new IllegalArgumentException(errorMessage);
            }
            uniqueInputs.add(input);
        }
    }

    private static void validateNonNegative(int input, String errorMessage) {
        if (input < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateNotZero(int input, String errorMessage) {
        if (input == 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
