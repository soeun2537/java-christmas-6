package christmas.constant.message;

public enum OutputMessage {
    START_GUIDANCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE_GUIDANCE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENUS_GUIDANCE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    PREVIEW_GUIDANCE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_GUIDANCE("<주문 메뉴>"),
    ORDER_MENU("%s %d개"),
    TOTAL_BEFORE_DISCOUNT_GUIDANCE("<할인 전 총주문 금액>"),
    TOTAL_BEFORE_DISCOUNT("%,d원"),
    GIFT_GUIDANCE("<증정 메뉴>"),
    GIFT("%s 1개"),
    DISCOUNT_DETAILS_GUIDANCE("<혜택 내역>"),
    DISCOUNT_DETAILS("%s: -%,d원"),
    TOTAL_DISCOUNT_GUIDANCE("<총혜택 금액>"),
    TOTAL_DISCOUNT("%,d원"),
    TOTAL_AFTER_DISCOUNT_GUIDANCE("<할인 후 예상 결제 금액>"),
    TOTAL_AFTER_DISCOUNT("%,d원"),
    EVENT_BADGE_GUIDANCE("<12월 이벤트 배지>"),
    EVENT_BADGE("%s"),

    NONE("없음")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
