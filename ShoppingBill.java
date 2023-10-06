package ProgramForShoppingBill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ShoppingBill {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Customer Name: ");
		String customerName = scan.nextLine();

		ShoppingCart cart = ShoppingCart.getInstance();

		do {
			String id = null;
			String productName = null;
			int quantity = 0;
			double price = 0.0;
			double totalPrice = 0.0;

			List<Product> products = new ArrayList<>();

			do {
				System.out.println("Enter the product details: ");
				System.out.print("Product ID: ");
				id = scan.nextLine();
				System.out.print("Product Name: ");
				productName = scan.nextLine();
				System.out.print("Quantity: ");
				quantity = scan.nextInt();
				System.out.print("Price (per unit): ");
				price = scan.nextDouble();
				totalPrice = price * quantity;
				products.add(new Product(id, productName, quantity, price, totalPrice));
				System.out.print("Want to add more items? (y or n): ");
				scan.nextLine(); // Consume the newline character left in the buffer
			} while (scan.nextLine().equalsIgnoreCase("y"));

			for (Product product : products) {
				cart.addProduct(product);
			}

			Invoice invoice = new Invoice(customerName, cart);
			invoice.generateInvoice();

			// Save the transaction details to a text file (append mode)
			saveTransactionToTextFile(customerName, cart);

			System.out.print("Do you want to start a new transaction? (y or n): ");
		} while (scan.nextLine().equalsIgnoreCase("y"));

		scan.close();
	}

	private static void saveTransactionToTextFile(String customerName, ShoppingCart cart) {
		try {
			FileWriter fileWriter = new FileWriter("transaction.txt", true); // Open in append mode
			PrintWriter printWriter = new PrintWriter(fileWriter);

			// Write transaction details to the file
			printWriter.println("Customer Name: " + customerName);
			printWriter.println("Date: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

			printWriter.println("Product ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price");
			for (Product product : cart.getProducts()) {
				printWriter.printf("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n",
						product.getId(), product.getPname(), product.getQty(), product.getPrice(), product.getTotalPrice());
			}

			printWriter.println("Total Amount (Rs.): " + cart.calculateTotalPrice());
			printWriter.println("Discount (Rs.): " + cart.calculateDiscount());
			printWriter.println("Subtotal: " + cart.calculateSubtotal());
			printWriter.println("SGST (%): " + cart.calculateTax());
			printWriter.println("CGST (%): " + cart.calculateTax());
			printWriter.println("Invoice Total: " + (cart.calculateSubtotal() + 2 * cart.calculateTax()));
			printWriter.println();

			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}