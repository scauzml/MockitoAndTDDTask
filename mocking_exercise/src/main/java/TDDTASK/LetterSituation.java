package TDDTASK;

public enum LetterSituation {
       All_SAME(1,"每张牌型相同");
       int code;
       String value;

    LetterSituation(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
