package christmas.model;

public enum EventBadge {
    없음(0, 5000),
    별(5000, 10000),
    트리(10000, 2000),
    산타(20000, Integer.MAX_VALUE),
    ;

    private int minDiscount;
    private int maxDiscount;

    EventBadge(int minDiscount, int maxDiscount) {
        this.minDiscount = minDiscount;
        this.maxDiscount = maxDiscount;
    }

    public int getMinDiscount() {
        return minDiscount;
    }

    public int getMaxDiscount() {
        return maxDiscount;
    }

    public static EventBadge findEventBadgeByDiscount(int discount) {
        for (EventBadge eventBadge : values()) {
            if (discount >= eventBadge.getMinDiscount() && discount < eventBadge.getMaxDiscount()) {
                return eventBadge;
            }
        }
        return EventBadge.없음;
    }
}
