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

class ShoppingCart {
	private static ShoppingCart instance;
	private List<Product> products;

	private ShoppingCart() {
		products = new ArrayList<>();
	}

	public static ShoppingCart getInstance() {
		if (instance == null) {
			instance = new ShoppingCart();
		}
		return instance;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public double calculateTotalPrice() {
		double total = 0.0;
		for (Product product : products) {
			total += product.getTotalPrice();
		}
		return total;
	}

	public double calculateDiscount() {
		// Add logic for calculating discounts based on promotions or rules
		// For now, a 2% discount on the total price is applied
		return calculateTotalPrice() * 0.02;
	}

	public double calculateTax() {
		// Calculate taxes based on the total price
		// For now, assume 12% GST
		return calculateTotalPrice() * 0.12;
	}

	public double calculateSubtotal() {
		return calculateTotalPrice() - calculateDiscount();
	}

	public List<Product> getProducts() {
		return products;
	}
}