package christmas.model;

import java.util.ArrayList;
import java.util.List;

public enum Board {
    양송이수프("에피타이저", 6000),
    타파스("에피타이저", 5500),
    시저샐러드("에피타이저", 8000),
    티본스테이크("메인", 55000),
    바비큐립("메인", 54000),
    해산물파스타("메인", 35000),
    크리스마스파스타("메인", 25000),
    초코케이크("디저트", 15000),
    아이스크림("디저트", 5000),
    제로콜라("음료", 3000),
    레드와인("음료", 600000),
    샴페인("음료", 25000),
    ;

    private final String category;
    private final int price;

    Board(String category, int price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public static int getPriceByName(String name) {
        for (Board board : values()) {
            if (board.name().equals(name)) {
                return board.getPrice();
            }
        }
        throw new IllegalArgumentException();
    }

    public static int getMenuCountByCategory(List<Menu> menus, String category) {
        int count = 0;
        for (Menu menu : menus) {
            if (findMenuNamesByCategory(category).contains(menu.getName())) {
                count += menu.getCount();
            }
        }
        return count;
    }

    private static List<String> findMenuNamesByCategory(String category) {
        List<String> menuNames = new ArrayList<>();
        for (Board board : values()) {
            if (board.getCategory().equals(category)) {
                menuNames.add(board.name());
            }
        }
        return menuNames;
    }
}
