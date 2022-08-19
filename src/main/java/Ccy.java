public enum Ccy {
    USD("Dollar","USD"),
    EUR("Yevro","EUR"),
    RUB("Rubl","RUB"),
    GPB("Angliya funt sterlingi","GPB");

    private final String name;
    private final String ccy;

    Ccy(String name,String ccy) {
        this.name = name;
        this.ccy = ccy;
    }

    public String getName() {
        return name;
    }

    public String getCcy() {
        return ccy;
    }
}
