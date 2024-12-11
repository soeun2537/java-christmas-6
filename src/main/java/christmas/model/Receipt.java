package christmas.model;

import static christmas.constant.message.OutputMessage.*;

import java.util.EnumMap;
import java.util.List;

public class Receipt {

    private int visitDate;
    private Menus menus;
    private EnumMap<Discount, Integer> discountDetails;

    public Receipt(int visitDate, Menus menus, EnumMap<Discount, Integer> discountDetails) {
        this.visitDate = visitDate;
        this.menus = menus;
        this.discountDetails = discountDetails;
    }

    public static Receipt from(int visitDate, Menus menus, EnumMap<Discount, Integer> discountDetails) {
        return new Receipt(visitDate, menus, discountDetails);
    }

    public int getVisitDate() {
        return visitDate;
    }

    public List<Menu> getMenus() {
        return menus.getMenus();
    }

    public int getTotalBeforeDiscount() {
        return menus.getTotal();
    }

    public String getGift() {
        if (discountDetails.containsKey(Discount.증정_이벤트)) {
            return Board.샴페인.name();
        }
        return NONE.getMessage();
    }

    public EnumMap<Discount, Integer> getDiscountDetails() {
        if (getTotalDiscount() == 0) {
            return new EnumMap<>(Discount.class);
        }
        return discountDetails;
    }

    public int getTotalDiscount() {
        int total = 0;
        for (Integer discount : discountDetails.values()) {
            total += discount;
        }
        return - total;
    }

    public int getTotalAfterDiscount() {
        int totalAfterDiscount = getTotalBeforeDiscount() - getTotalDiscount();
        if (getGift().equals(Board.샴페인.name())) {
            totalAfterDiscount += discountDetails.get(Discount.증정_이벤트);
        }
        return totalAfterDiscount;
    }

    public String getEventBadge() {
        EventBadge eventBadge = EventBadge.findEventBadgeByDiscount(getTotalDiscount());
        return eventBadge.name();
    }
}
