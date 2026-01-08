package Tomov;

public enum Currency {
    BGN(1.0), EUR(0.51129);

    private final double rateToLev;

    Currency(double rateToLev) {
        this.rateToLev = rateToLev;
    }

    public double convertFromLev(double amount) {
        return Math.round(amount * rateToLev * 100.0) / 100.0;
    }

    public double convertToLev(double amount) {
        return Math.round(amount / rateToLev * 100.0) / 100.0;
    }
}