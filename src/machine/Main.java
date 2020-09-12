package machine;

import java.util.Scanner;

class CoffeeMachine {
    static int availableWater = 400;
    static int availableMilk = 540;
    static int availableBeans = 120;
    static int availableCups = 9;
    static int money = 550;
    static boolean isWork = true;

    public static void printInfo(int availableWater, int availableMilk, int availableBeans, int availableCups, int money) {
        System.out.printf("%d of water\n", availableWater);
        System.out.printf("%d of milk\n", availableMilk);
        System.out.printf("%d of coffee beans\n", availableBeans);
        System.out.printf("%d of disposable cups\n", availableCups);
        System.out.printf("%d of money\n", money);
    }

    public static String getAction(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, exit, remaining):");
        return scanner.next();
    }

    public static boolean hasResources(String typeOfCoffee, int availableWater, int availableMilk, int availableBeans, int availableCups, int money) {
        boolean hasResourcesFlag = true;
        switch (typeOfCoffee) {
            case "1": {
                if (availableWater < 250) {
                    System.out.println("Sorry, not enough water!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResourcesFlag = false;
                    break;
                }
                break;
            }
            case "2": {
                if (availableWater < 350) {
                    System.out.println("Sorry, not enough water!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableMilk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResourcesFlag = false;
                    break;
                }
                break;
            }
            case "3": {
                if (availableWater < 200) {
                    System.out.println("Sorry, not enough water!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableMilk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    hasResourcesFlag = false;
                    break;
                }
                if (availableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    hasResourcesFlag = false;
                    break;
                }
                break;
            }
        }
        return hasResourcesFlag;
    }

    public static void handleAction(String action, Scanner scanner) {
        switch (action) {
            case "take": {
                System.out.printf("I gave you %d\n", money);
                money = 0;
                break;
            }
            case "fill": {
                System.out.println("Write how many ml of water do you want to add:");
                availableWater += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                availableMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                availableBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                availableCups += scanner.nextInt();
                break;
            }
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String typeOfCoffee = scanner.next();
                if (typeOfCoffee == "back") break;
                if (hasResources(typeOfCoffee, availableWater, availableMilk, availableBeans, availableCups, money)) {
                    switch (typeOfCoffee) {
                        case "1": {
                            availableWater -= 250;
                            availableBeans -= 16;
                            availableCups--;
                            money += 4;
                            break;
                        }
                        case "2": {
                            availableWater -= 350;
                            availableMilk -= 75;
                            availableBeans -= 20;
                            availableCups--;
                            money += 7;
                            break;
                        }
                        case "3": {
                            availableWater -= 200;
                            availableMilk -= 100;
                            availableBeans -= 12;
                            availableCups--;
                            money += 6;
                            break;
                        }
                    }
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            }
            case "exit": {
                isWork = false;
                break;
            }
            case "remaining": {
                printInfo(availableWater, availableMilk, availableBeans, availableCups, money);
            }
        }
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        while (isWork) {
            String action = getAction(scanner);
            handleAction(action, scanner);
        }
    }

    public static void main(String[] args) {
        start();
    }
}
