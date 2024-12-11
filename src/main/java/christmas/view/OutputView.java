package christmas.view;

import static christmas.constant.message.OutputMessage.*;

import christmas.constant.message.OutputMessage;
import christmas.model.Discount;
import christmas.model.Menu;
import christmas.model.Receipt;
import christmas.util.Parser;
import java.util.Map.Entry;

public class OutputView {

    public static void printStartGuidance() {
        println(START_GUIDANCE.getMessage());
    }

    public static void printVisitDateGuidance() {
        println(VISIT_DATE_GUIDANCE.getMessage());
    }

    public static void printMenusGuidance() {
        println(MENUS_GUIDANCE.getMessage());
    }

    public static void printReceipt(Receipt receipt) {
        println(PREVIEW_GUIDANCE.getMessage(receipt.getVisitDate()));
        printNewLine();

        println(ORDER_MENU_GUIDANCE.getMessage());
        for (Menu menu : receipt.getMenus()) {
            println(ORDER_MENU.getMessage(menu.getName(), menu.getCount()));
        }
        printNewLine();

        println(TOTAL_BEFORE_DISCOUNT_GUIDANCE.getMessage());
        println(TOTAL_BEFORE_DISCOUNT.getMessage(receipt.getTotalBeforeDiscount()));
        printNewLine();

        println(GIFT_GUIDANCE.getMessage());
        if (receipt.getGift().equals(NONE.getMessage())) {
            println(NONE.getMessage());
        } else {
            println(GIFT.getMessage(receipt.getGift()));
        }
        printNewLine();

        println(DISCOUNT_DETAILS_GUIDANCE.getMessage());
        if (receipt.getDiscountDetails().isEmpty()) {
            println(NONE.getMessage());
        } else {
            for (Entry<Discount, Integer> discountEntry : receipt.getDiscountDetails().entrySet()) {
                String discountName = discountEntry.getKey().name();
                String replacedDiscountName = Parser.replaceUnderbar(discountName);
                println(DISCOUNT_DETAILS.getMessage(replacedDiscountName, discountEntry.getValue()));
            }
        }
        printNewLine();

        println(TOTAL_DISCOUNT_GUIDANCE.getMessage());
        println(TOTAL_DISCOUNT.getMessage(receipt.getTotalDiscount()));
        printNewLine();

        println(TOTAL_AFTER_DISCOUNT_GUIDANCE.getMessage());
        println(TOTAL_AFTER_DISCOUNT.getMessage(receipt.getTotalAfterDiscount()));
        printNewLine();

        println(EVENT_BADGE_GUIDANCE.getMessage());
        println(EVENT_BADGE.getMessage(receipt.getEventBadge()));
    }


    public static void printErrorMessage(RuntimeException e) {
        println(e.getMessage());
    }

    private static void println(String content) {
        System.out.println(content);
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
