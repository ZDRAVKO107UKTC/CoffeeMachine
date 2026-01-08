# Coffee Machine Project

This project simulates a **Coffee Machine** with functionality to display coffee prices, accept payment in multiple currencies, and dispense coffee with appropriate change in dual-currency denominations.

## Overview

The project provides a console-based interface for users to interact with the Coffee Machine. Users can:

- **View available coffees and their prices.**
- **Purchase coffee by entering payment in selected currency (BGN or EUR).**
- **Receive change in dual currencies (BGN and EUR) if applicable.**

### Key Features:
1. **Multiple Coffee Options:** The coffee machine offers a variety of coffee types such as Espresso, Latte, and Cappuccino, each with different prices, ingredient requirements, and preparation times.
2. **Dual Currency Support:** Payments can be made using **BGN** or **EUR**, and change is returned in a dual-currency manner.
3. **Stock and Ingredient Management:** The machine tracks available water, milk, and coffee stock for making the beverages.
4. **Interactive Console Interface:** Provides a simple menu for users to choose and order coffee or display prices.

---

## Functionalities

### **1. Coffee Types and Pricing**
- Espresso: Price — 3.00 BGN
- Latte: Price — 5.00 BGN
- Cappuccino: Price — 4.00 BGN

The menu displays the list of available coffees and their prices.

### **2. Purchase Coffee**
- The machine allows users to enter the name of the desired coffee, select a payment currency, and provide the payment amount.
- It calculates the price and processes the order, deducting the required stock of ingredients.

### **3. Dual-Currency Change**
- If the payment exceeds the coffee price, the machine provides the remaining amount as change.
- The change is calculated in a combination of **BGN** and **EUR** denominations.

### **4. Ingredient and Stock Management**
- The coffee machine keeps track of the stock of water, milk, coffee beans, and cups.
- Ensures that a coffee can only be made if enough stock is available for the selected coffee type.

---

## Usage Instructions

1. **Run the Coffee Machine Program:**
   - Launch the program through the main method in `CoffeeMachineTest`.

2. **Choose an Option:**
   - The program provides the following options via a simple menu:
     1. **Buy Coffee**
        - Enter the name of the desired coffee.
        - Select the payment currency (BGN or EUR).
        - Provide the payment amount.
        - If sufficient payment is provided, the coffee is dispensed; any change is returned in dual currency.
     2. **Display Prices**
        - Shows the available coffees and their prices.
     3. **Exit**
        - Exits the program.

3. **Follow the Prompts:**
   - The program will guide you with instructions while making a selection or purchasing coffee.

4. **Check Change (if applicable):**
   - If you provide more than the coffee price, the program will calculate and display the returned change.

---

## Example Interaction

**Initial Menu:**
Choose an option:
1. Buy coffee
2. Display prices
3. Exit
``` 

**If Buying Coffee:**
```
Enter coffee name: Latte Choose payment currency:
1. BGN
2. EUR Enter payment amount (BGN): 6.00 Buying Latte with 6.00 BGN Change returned:

- 1.00 BGN Coins
``` 

**If Displaying Prices:**
```
Available coffees and prices:
- Espresso: 3.00 BGN
- Latte: 5.00 BGN
- Cappuccino: 4.00 BGN
``` 

---

## Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK version 23 or later installed.
- **Development Environment:** This project is compatible with IntelliJ IDEA 2025.1.1.1 or other Java IDEs.

---

## How to Run

1. Clone the repository or download the project files.
2. Open the project in your preferred Java IDE.
3. Compile and run the `CoffeeMachineTest` class.
4. Follow the on-screen instructions to interact with the Coffee Machine.

---

## Project Structure

- **CoffeeMachineTest:** The entry point for running the Coffee Machine application.
- **CoffeeMachine:** Core class that handles coffee preparation, payment, and change calculation.
- **Coffee:** Represents individual coffee types with attributes like price, preparation time, and ingredient requirements.
- **DualCurrencyChange:** Handles the calculation and display of change in dual currency denominations.
- **Currency:** Enum for currencies supported by the machine (BGN, EUR).
- **CurrencyDenominations:** Provides currency denomination values for different currencies.

---

## Future Enhancements

- Add support for additional beverages.
- Implement stock refill functionality.
- Introduce card payments alongside cash-based payments.
- Provide multi-language support for the interface.

---

## License

This project is open-source and available for use/modification under a standard open-source license.

--- 

Thank you for using the Coffee Machine project! Enjoy your coffee! ☕
```
