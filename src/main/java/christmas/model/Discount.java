package christmas.model;

import java.time.LocalDate;
import java.util.EnumMap;

public enum Discount {

    크리스마스_디데이_할인,
    평일_할인,
    주말_할인,
    특별_할인,
    증정_이벤트
    ;

    public static EnumMap<Discount, Integer> findDiscount(LocalDate visitDate, Menus menus) {
        EnumMap<Discount, Integer> discountDetails = new EnumMap<>(Discount.class);
        if (visitDate.getDayOfMonth() <= 25) {
            discountDetails.put(크리스마스_디데이_할인, 1000 + (visitDate.getDayOfMonth() - 1) * 100);
        }
        int dayOfWeek = visitDate.getDayOfWeek().getValue();
        if (dayOfWeek == 7 || (dayOfWeek >= 1 && dayOfWeek <= 4)) {
            discountDetails.put(평일_할인, Board.getMenuCountByCategory(menus.getMenus(), "디저트") * 2023);
        }
        if (dayOfWeek == 5 || dayOfWeek == 6) {
            discountDetails.put(주말_할인, Board.getMenuCountByCategory(menus.getMenus(), "메인") * 2023);
        }
        if (dayOfWeek == 7 || visitDate.getDayOfMonth() == 25) {
            discountDetails.put(특별_할인, 1000);
        }
        if (menus.getTotal() > 120000) {
            discountDetails.put(증정_이벤트, Board.getPriceByName(Board.샴페인.name()));
        }
        return discountDetails;
    }
}
