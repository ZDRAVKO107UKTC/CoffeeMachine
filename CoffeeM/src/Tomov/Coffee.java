package Tomov;

public class Coffee {
    private String name;
    private int coffeeNeeded, milkNeeded, waterNeeded;
    private double price;
    private Currency priceCurrency;

    public Coffee(int coffeeNeeded, int milkNeeded, String name, double price, int waterNeeded) {
        this.coffeeNeeded = coffeeNeeded;
        this.milkNeeded = milkNeeded;
        this.name = name.trim();
        this.price = price;
        this.waterNeeded = waterNeeded;
        this.priceCurrency = Currency.BGN;
    }

    public String getName() {
        return name;
    }

    public int getCoffeeNeeded() {
        return coffeeNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public double getPrice() {
        return price;
    }

    public Currency getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(Currency currency) {
        if (this.priceCurrency != currency) {
            this.price = currency.convertFromLev(this.priceCurrency.convertToLev(this.price));
            this.priceCurrency = currency;
        }
    }

    public boolean matchesName(String otherName) {
        return this.name.equalsIgnoreCase(otherName.trim());
    }
}