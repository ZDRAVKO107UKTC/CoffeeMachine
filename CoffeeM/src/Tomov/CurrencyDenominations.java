package Tomov;

public class CurrencyDenominations {
    private static final double[] BGN_COINS = {2.00, 1.00, 0.50, 0.20, 0.10, 0.05};
    private static final double[] EUR_COINS = {2.00, 1.00, 0.50, 0.20, 0.10, 0.05};

    public static double[] getCoinsForCurrency(Currency currency) {
        return currency == Currency.BGN ? BGN_COINS.clone() : EUR_COINS.clone();
    }
}