package Tomov;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachineTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine machine = initializeMachine();
        runMachineDemo(machine);
    }

    private static CoffeeMachine initializeMachine() {
        ArrayList<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee(20, 10, "Espresso", 3.00, 30));
        coffees.add(new Coffee(20, 50, "Latte", 5.00, 100));
        coffees.add(new Coffee(20, 30, "Cappuccino", 4.00, 80));

        return new CoffeeMachine(
                1000, 2000, 2000, 3000,
                coffees,
                CurrencyDenominations.getCoinsForCurrency(Currency.BGN),
                new int[]{50, 50, 50, 50, 50, 50},
                Currency.BGN
        );
    }

    private static void runMachineDemo(CoffeeMachine machine) {
        machine.displayPrices();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Buy coffee");
            System.out.println("2. Display prices");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                buyCoffee(machine);
            } else if (choice == 2) {
                machine.displayPrices();
            } else if (choice == 3) {
                System.out.println("Thank you for using our coffee machine!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void buyCoffee(CoffeeMachine machine) {
        System.out.print("Enter coffee name: ");
        String coffeeType = scanner.nextLine();

        System.out.println("Choose payment currency:");
        System.out.println("1. BGN");
        System.out.println("2. EUR");
        int currencyChoice = scanner.nextInt();
        scanner.nextLine();

        Currency paymentCurrency = currencyChoice == 2 ? Currency.EUR : Currency.BGN;

        System.out.printf("Enter payment amount (%s): ", paymentCurrency);
        double payment = scanner.nextDouble();
        scanner.nextLine();

        System.out.printf("\nBuying %s with %.2f %s%n", coffeeType, payment, paymentCurrency);

        DualCurrencyChange change = machine.makeCoffee(payment, paymentCurrency, coffeeType);

        if (change.hasChange()) {
            change.displayChange();
        }
    }
}