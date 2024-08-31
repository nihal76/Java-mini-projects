package abstraction;

import java.util.Scanner;

abstract class PaymentMethod{
	long phone;
	int amount;
	abstract void acceptInput(Scanner sc);
	abstract void processPayment();
}
class Payment extends PaymentMethod{
	void acceptInput(Scanner sc) {
		System.out.println("Accept different payment methods");
	}
	void processPayment() {
		System.out.println("process different payment methods");
	}
}
class CreditCard extends Payment{
	private long creditCardNo;
	private int cvv;
	private String cardHolder;
	@Override
	void acceptInput(Scanner sc) {
		System.out.println("Enter the phone number");
		phone = sc.nextLong();
		System.out.println("Enter the credit card number");
		creditCardNo = sc.nextLong();
		System.out.println("Enter the cvv");
		cvv = sc.nextInt();
		System.out.println("Enter your name");
		cardHolder = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the amount to pay");
		amount = sc.nextInt();
	}
	@Override
	void processPayment() {
		System.out.println(amount);
		System.out.println("Credit card Payment processing...");
	}
}
class DebitCard extends Payment{
	private long DebitCardNo;
	private int pin;
	private String cardHolder;
	@Override
	void acceptInput(Scanner sc) {
		System.out.println("Enter the phone number");
		phone = sc.nextLong();
		System.out.println("Enter the debit card number");
		DebitCardNo = sc.nextLong();
		System.out.println("Enter your pin");
		pin = sc.nextInt();
		System.out.println("Enter your name");
		cardHolder = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the amount to pay");
		amount = sc.nextInt();
	}
	@Override
	void processPayment() {
		System.out.println(amount);
		System.out.println("Debit card Payment processing...");
	}
}
class UPI extends Payment{
	String upiId;
	void acceptInput(Scanner sc){
		System.out.println("Enter the phone number");
		phone = sc.nextLong();
		System.out.println("Enter the UPI id");
		upiId = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the amount to pay");
		amount = sc.nextInt();
	}
	void processPayment() {
		System.out.println(amount);
		System.out.println("UPI payment processing...");
	}
}


public class onlineShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
       System.out.println("Choose different payment methods");
       System.out.println("1.CreditCard\n 2.DebitCard\n 3.UPI");
       int option = sc.nextInt();
       switch(option) {
       case 1:
    	   Payment pay = new CreditCard();
    	   pay.acceptInput(sc);
    	   pay.processPayment();
    	   break;
       case 2:
    	   Payment pay2 = new DebitCard();
    	   pay2.acceptInput(sc);
    	   pay2.processPayment();
    	   break;
       case 3:
    	   Payment pay3 = new UPI();
    	   pay3.acceptInput(sc);
    	   pay3.processPayment();
    	   break;
       default:
    	   System.out.println("Choose the correct payment");
	}

}
}
