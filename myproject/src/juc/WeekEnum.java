package juc;

public enum WeekEnum {
    ONE(1,"星期一"),TEO(2,"星期二"),THREE(3,"星期三"),FOUR(4,"星期四")
    ,FIVE(5,"星期五"),SIX(6,"星期六"),SEVEN(7,"星期日");

    private Integer retCode;
    private String retMessage;

    public static WeekEnum forEach_WeekEnum(int index){
        WeekEnum[] weekEnums = WeekEnum.values();
        for (WeekEnum week:weekEnums) {
            if (index == week.getRetCode()){
                return week;
            }
        }
        return null;
    }

    WeekEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
