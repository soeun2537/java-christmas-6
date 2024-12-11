package christmas.constant;

public enum InputConstant {
    NUMERIC_PATTERN("\\d+"),
    DAY_PATTERN("^(월|화|수|목|금|토|일)$"),
    CHARACTER_PATTERN("^[가-힣]+$"),
    INPUT_SEPARATOR(","),
    MENU_SEPARATOR("-"),

    UNDERBAR("_"),
    BLANK(" ")
    ;

    private final String content;

    InputConstant(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
