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

class Invoice {
	private String customerName;
	private ShoppingCart cart;

	public Invoice(String customerName, ShoppingCart cart) {
		this.customerName = customerName;
		this.cart = cart;
	}

	public void generateInvoice() {
		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "Metro Mart Grocery Shop");
		System.out.println("\t\t\t\t\t3/98 Mecrobertganj New Mumbai");
		System.out.println("\t\t\t\t\t" + "    " + "Opposite Metro Walk");
		System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+7) 7088350549");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t (+7) 7089782062");

		System.out.print("Enter Customer Name: ");
		System.out.println(customerName);

		Product.displayFormat();
		for (Product p : cart.getProducts()) {
			p.display();
		}

		System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + cart.calculateTotalPrice());
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + cart.calculateDiscount());
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + cart.calculateSubtotal());
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) " + cart.calculateTax());
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) " + cart.calculateTax());
		System.out
				.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (cart.calculateSubtotal() + 2 * cart.calculateTax()));
		System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
		System.out.println("\t\t\t\t                     Visit Again");
	}
}