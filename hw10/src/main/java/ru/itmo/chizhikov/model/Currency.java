package ru.itmo.chizhikov.model;

public enum Currency {
    USD,
    EUR,
    RUB;

    private double getCourse() {
        switch (this) {
            case EUR:
                return 0.84;
            case RUB:
                return 73.12;
            default:
                return 1;
        }
    }

    public double getCourse(Currency otherCurrency) {
        return otherCurrency.getCourse() / getCourse();
    }
}