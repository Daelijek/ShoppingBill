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

class Product {
	// properties
	private String id;
	private String pname;
	private int qty;
	private double price;
	private double totalPrice;

	// constructor
	Product(String id, String pname, int qty, double price, double totalPrice) {
		this.id = id;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	// getter methods
	public String getId() {
		return id;
	}

	public String getPname() {
		return pname;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	// displayFormat
	public static void displayFormat() {
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");
	}

	// display
	public void display() {
		System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n", id, pname,
				qty, price, totalPrice);
	}
}