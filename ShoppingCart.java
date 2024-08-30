package polymorphism;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Product {
    String name;
    int price;
    String description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    void computePrice(float discount) {
        System.out.println("Calculate price for each category of product");
    }

    abstract float discount(int price);
}

class Electronics extends Product {
    String brand;
    String model;

    public Electronics(String name, int price, String description, Scanner sc) {
        super(name, price, description);
        System.out.println("Enter the brand:");
        this.brand = sc.nextLine();
        System.out.println("Enter the model:");
        this.model = sc.nextLine();
    }

    @Override
    float discount(int price) {
        int[] discount = {25, 15, 20, 18, 30};
        Random random = new Random();
        int randomIndex = random.nextInt(discount.length);
        System.out.println(discount[randomIndex] + "%" + " discount applied to " + super.name);
        return (price - ((price * discount[randomIndex]) / 100));
    }

    @Override
    void computePrice(float price) {
        TotalItems.totalPrice(price);
    }
}

class Books extends Product {
    String author;
    String bookType;

    public Books(String name, int price, String description, Scanner sc) {
        super(name, price, description);
        System.out.println("Enter the author of the book:");
        this.author = sc.nextLine();
        System.out.println("Enter the type of book you want:");
        this.bookType = sc.nextLine();
    }

    float discount(int price) {
        int[] discount = {25, 35, 20, 45, 50};
        Random random = new Random();
        int rand = random.nextInt(discount.length);
        System.out.println(discount[rand] + "%" + " discount applied to " + super.name);
        return (price - ((price * discount[rand]) / 100));
    }

    @Override
    void computePrice(float price) {
        TotalItems.totalPrice(price);
    }
}

class TotalItems {
    static int cartPrice = 0;

    public static void totalPrice(float price) {
        cartPrice += price;
    }
}

class AddToCart {
    public static void addToCart(Scanner sc) {
        System.out.println("1. Electronics\n2. Books");
        int option = sc.nextInt();
        sc.nextLine(); // Clear the newline

        switch (option) {
            case 1:
                System.out.println("Enter the product name:");
                String name = sc.nextLine();
                System.out.println("Enter the price:");
                int price = sc.nextInt();
                sc.nextLine(); // Clear the newline
                System.out.println("Enter the description:");
                String desc = sc.nextLine();
                Product prod = new Electronics(name, price, desc, sc);
                float discount = prod.discount(price);
                prod.computePrice(discount);
                break;

            case 2:
                System.out.println("Enter the product name:");
                String name2 = sc.nextLine();
                System.out.println("Enter the price:");
                int price2 = sc.nextInt();
                sc.nextLine(); // Clear the newline
                System.out.println("Enter the description:");
                String desc2 = sc.nextLine();
                Product prod2 = new Books(name2, price2, desc2, sc);
                float discount2 = prod2.discount(price2);
                prod2.computePrice(discount2);
                break;

            default:
                System.out.println("Invalid option selected.");
                break;
        }
    }
}

public class ShoppingCart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Want to add items to the cart?");
        System.out.println("1. Yes\n2. No");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("How many items do you want to add to the cart?");
            int items = sc.nextInt();

            for (int i = 0; i < items; i++) {
                AddToCart.addToCart(sc);
            }
        } else {
            System.exit(0);
        }

        int cartPrice = TotalItems.cartPrice;
        System.out.println("Total cart price: " + cartPrice);
    }
}
