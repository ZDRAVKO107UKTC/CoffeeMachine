package Tomov;

import java.util.ArrayList;

public class CoffeeMachine {
    private double coffeeAmount, waterAmount, milkAmount, sugarAmount;
    private double[] changeCoins;
    private int[] changeCoinsAmount;
    private ArrayList<Coffee> coffeesAvailable;
    private Currency currentCurrency;

    public CoffeeMachine(double coffeeAmount, double milkAmount, double sugarAmount, double waterAmount,
                         ArrayList<Coffee> coffeesAvailable, double[] changeCoins, int[] changeCoinsAmount,
                         Currency currency) {
        this.coffeeAmount = coffeeAmount;
        this.milkAmount = milkAmount;
        this.sugarAmount = sugarAmount;
        this.waterAmount = waterAmount;
        this.coffeesAvailable = coffeesAvailable;
        this.changeCoins = changeCoins;
        this.changeCoinsAmount = changeCoinsAmount;
        this.currentCurrency = currency;
        for (Coffee coffee : coffeesAvailable) {
            coffee.setPriceCurrency(currency);
        }
    }

    public Currency getCurrency() {
        return currentCurrency;
    }

    public void setCurrency(Currency newCurrency) {
        if (this.currentCurrency != newCurrency) {
            this.changeCoins = CurrencyDenominations.getCoinsForCurrency(newCurrency);
            for (Coffee coffee : coffeesAvailable) {
                coffee.setPriceCurrency(newCurrency);
            }
            this.currentCurrency = newCurrency;
        }
    }

    public void displayPrices() {
        for (Coffee coffee : coffeesAvailable) {
            double priceInBGN = coffee.getPriceCurrency() == Currency.BGN ? coffee.getPrice()
                    : Currency.BGN.convertFromLev(coffee.getPrice());
            double priceInEUR = Currency.EUR.convertFromLev(priceInBGN);
            System.out.printf("%s: %.2f BGN / %.2f EUR%n", coffee.getName(), priceInBGN, priceInEUR);
        }
    }

    public DualCurrencyChange makeCoffee(double insertedMoney, Currency paymentCurrency, String coffeeType) {
        Coffee coffeeToMake = coffeesAvailable.stream().filter(coffee -> coffee.matchesName(coffeeType)).findFirst().orElse(null);
        DualCurrencyChange dualChange = new DualCurrencyChange();
        if (coffeeToMake == null) return dualChange;

        double insertedInBGN = paymentCurrency.convertToLev(insertedMoney);
        double priceInBGN = coffeeToMake.getPriceCurrency().convertToLev(coffeeToMake.getPrice());

        if (insertedInBGN >= priceInBGN && resourcesAvailable(coffeeToMake)) {
            useResources(coffeeToMake);
            return calculateDualChange(insertedInBGN - priceInBGN);
        }
        return dualChange;
    }

    private void useResources(Coffee coffee) {
        coffeeAmount -= coffee.getCoffeeNeeded();
        milkAmount -= coffee.getMilkNeeded();
        waterAmount -= coffee.getWaterNeeded();
    }

    private boolean resourcesAvailable(Coffee coffee) {
        return coffeeAmount >= coffee.getCoffeeNeeded()
                && waterAmount >= coffee.getWaterNeeded()
                && milkAmount >= coffee.getMilkNeeded();
    }

    private DualCurrencyChange calculateDualChange(double changeInBGN) {
        DualCurrencyChange dualChange = new DualCurrencyChange();
        double[] bgnCoins = CurrencyDenominations.getCoinsForCurrency(Currency.BGN);
        dualChange.setBGNChange(calculateChangeInCurrency(changeInBGN, bgnCoins));
        double[] eurCoins = CurrencyDenominations.getCoinsForCurrency(Currency.EUR);
        dualChange.setEURChange(calculateChangeInCurrency(Currency.BGN.convertToLev(changeInBGN), eurCoins));
        return dualChange;
    }

    private double[][] calculateChangeInCurrency(double amount, double[] coins) {
        double[] coinCount = new double[coins.length];
        double[][] result = {coins, coinCount};
        for (int i = 0; i < coins.length && amount > 0; i++) {
            int count = (int) (amount / coins[i]);
            if (count <= changeCoinsAmount[i]) {
                coinCount[i] = count;
                amount -= count * coins[i];
            }
        }
        return result;
    }
}