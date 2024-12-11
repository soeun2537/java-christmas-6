package christmas.model;

import java.util.Collections;
import java.util.List;

public class Menus {

    List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus from(List<Menu> menus) {
        return new Menus(menus);
    }

    public int getTotal() {
        int total = 0;
        for (Menu menu : menus) {
            total += Board.getPriceByName(menu.getName()) * menu.getCount();
        }
        return total;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
