package model;

public enum Currency {
    USD,
    EUR,
    RUB;

    private double getMultiplier() {
        switch (this) {
            case EUR:
                return 0.84;
            case RUB:
                return 73.12;
            default:
                return 1;
        }
    }

    public double getMultiplier(Currency otherCurrency) {
        return otherCurrency.getMultiplier() / getMultiplier();
    }
}