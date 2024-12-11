package christmas.view;


import static christmas.constant.InputConstant.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu;
import christmas.model.Menus;
import christmas.util.Parser;
import christmas.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int readVisitDate() {
        String input = input();
        Validator.validateVisitDateBeforeParsing(input);
        int visitDate = Parser.convertStringToInteger(input);
        Validator.validateVisitDateAfterParsing(visitDate);
        return visitDate;
    }

    public static Menus readMenus() {
        String input = input();
        Validator.validateMenuBeforeParsing(input);
        List<String> separatedMenus = Parser.separateBySeparator(input, INPUT_SEPARATOR.getContent());
        List<String> menuNames = new ArrayList<>();
        List<Integer> menuCounts = new ArrayList<>();
        for (String menu : separatedMenus) {
            List<String> separatedMenuEntry = Parser.separateBySeparator(menu, "-");
            Validator.validateMenuName(separatedMenuEntry.get(0));
            menuNames.add(separatedMenuEntry.get(0));
            Validator.validateMenuCount(separatedMenuEntry.get(1));
            menuCounts.add(Parser.convertStringToInteger(separatedMenuEntry.get(1)));
        }
        Validator.validateMenuNames(menuNames);
        Validator.validateMenuCounts(menuCounts);

        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < separatedMenus.size(); i++) {
            menus.add(Menu.from(menuNames.get(i), menuCounts.get(i)));
        }

        return Menus.from(menus);
    }

    private static String input() {
        return Console.readLine();
    }
}
