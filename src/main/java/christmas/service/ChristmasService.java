package christmas.service;

import christmas.model.Discount;
import christmas.model.Menus;
import christmas.model.Receipt;
import java.time.LocalDate;
import java.util.EnumMap;

public class ChristmasService {

    public Receipt calculate(int visitDate, Menus menus) {
        LocalDate localVisitDate = LocalDate.of(2023, 12, visitDate);
        EnumMap<Discount, Integer> discountDetails = Discount.findDiscount(localVisitDate, menus);
        return Receipt.from(visitDate, menus, discountDetails);
    }
}
