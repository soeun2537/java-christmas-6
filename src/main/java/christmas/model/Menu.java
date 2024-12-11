package christmas.model;

public class Menu {

    private String name;
    private int count;

    private Menu(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static Menu from(String name, int count) {
        return new Menu(name, count);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
