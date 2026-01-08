package Tomov;

public class DualCurrencyChange {
    private double[][] bgnChange;
    private double[][] eurChange;

    public void setBGNChange(double[][] bgnChange) {
        this.bgnChange = bgnChange;
    }

    public void setEURChange(double[][] eurChange) {
        this.eurChange = eurChange;
    }

    public void displayChange() {
        displayCurrencyChange(bgnChange, "BGN");
        displayCurrencyChange(eurChange, "EUR");
    }

    private void displayCurrencyChange(double[][] change, String currency) {
        for (int i = 0; i < change[0].length; i++) {
            if (change[1][i] > 0) {
                System.out.printf("%.2f %s x %.0f%n", change[0][i], currency, change[1][i]);
            }
        }
    }

    public boolean hasChange() {
        return getTotalBGN() > 0 || getTotalEUR() > 0;
    }

    private int getTotalBGN() {
        int total = 0;
        if (bgnChange != null) {
            for (int i = 0; i < bgnChange[0].length; i++) {
                total += bgnChange[0][i] * bgnChange[1][i];
            }
        }
        return total;
    }

    private int getTotalEUR() {
        int total = 0;
        if (eurChange != null) {
            for (int i = 0; i < eurChange[0].length; i++) {
                total += eurChange[0][i] * eurChange[1][i];
            }
        }
        return total;
    }
}