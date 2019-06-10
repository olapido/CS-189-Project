// main class for ticket store, takes ticket orders, records sales, and sells tickets

// INTEGRATE WITH NEM

//import org.nem.core.model.*;
//import org.nem.core.crypto.*;
import java.util.Scanner;

public class TicketStore
{
	// static String test = "ORDER SUCCESSFUL";
	static Ticket tix;

	static int ticketOrders = 0;

	final static double ticketPriceReg = 10.00; // testnet (XEM) ticket price for a regular ticket
	final static double ticketPriceDisc = 9.00; // testnet (XEM) ticket price for bulk orders

	// static int customerID; // integrate with NEM (NEM Account Address)
	// static int ticketQuantity;

	static Scanner in = new Scanner(System.in);

	public TicketStore()
	{

	}

	// main method 
	public static void main(String[] args)
	{
		System.out.println("WELCOME TO TICKET STORE.");
		
		Boolean run = true;

		while(run)
		{
			int ticketQuantity;
			String customerID;

			System.out.println();
			System.out.println("Input 'end' to terminate TICKET STORE");
			System.out.println("Please input the quantity of tickets that you will purchase.");

			String in1 = in.nextLine();

			if(in1.equals("end"))
			{
				System.out.println();
				System.out.println("TICKET STORE TERMINATED.");
				break;
			}

			else
			{
				ticketQuantity = Integer.parseInt(in1);

				ticketOrders += ticketQuantity;
			}

			System.out.println();
			System.out.println("Input 'end' to terminate TICKET STORE");
			System.out.println("Please input your NEM address.");

			String in2 = in.nextLine();

			if(in2.equals("end"))
			{
				System.out.println();
				System.out.println("TICKET STORE TERMINATED.");
				break;
			}

			else
			{
				customerID = in2;
			}

			processOrder(ticketQuantity, customerID);
			double sc = getSalesCost(ticketQuantity);

			System.out.println();
			System.out.println("ORDER SUCCESFUL"); // print if the transaction has been confirmed in NEM
			System.out.println("Your order has been processed! The total cost of your order is " + sc + ". Thank you for your business.");
			System.out.println("Input 'end' to terminate TICKET STORE");
			System.out.println("Input 'rec' to view your official digital receipt.");
			System.out.println("Input any letter to make a new order.");

			String in3 = in.nextLine();

			if(in3.equals("end"))
			{
				System.out.println();
				System.out.println("TICKET STORE TERMINATED.");
				break;
			}

			else if(in3.equals("rec"))
			{
				printReceipt(ticketQuantity, customerID, sc);
			}

			System.out.println("Input 'end' to terminate TICKET STORE");
			System.out.println("Input any letter to make a new order.");

			String in4 = in.nextLine();

			if(in4.equals("end"))
			{
				System.out.println();
				System.out.println("TICKET STORE TERMINATED.");
				break;
			}
		}
	}

	public static void processOrder(int ticketQuantity, String customerID)
	{
		double salesCost;

		if(ticketQuantity < 5)
		{
			for(int i = 0; i < ticketQuantity; i++)
			{
				Ticket ticket = new Ticket(customerID, 0, ticketPriceReg);
			}

			salesCost = (ticketPriceReg * ticketQuantity);
		}

		else
		{
			for(int i = 0; i < ticketQuantity; i++)
			{
				Ticket ticket = new Ticket(customerID, 1, ticketPriceDisc);				
			}

			salesCost = (ticketPriceDisc * ticketQuantity);
		}

		// charge the customer for the sales cost of the ticket/s
		// NEM transaction
	}

	public static double getSalesCost(int ticketQuantity)
	{
		double salesCost;

		if(ticketQuantity < 5)
		{
			salesCost = (ticketPriceReg * ticketQuantity);
		}

		else
		{
			salesCost = (ticketPriceDisc * ticketQuantity);
		}

		return salesCost;
	}

	// prints receipt of last transaction
	public static void printReceipt(int ticketQuantity, String customerID, double salesCost)
	{
		System.out.println();
		System.out.println("--- OFFICIAL RECEIPT ---");

		if(ticketQuantity < 5)
		{
			System.out.println("Order Type: Regular");
		}

		else
		{
			System.out.println("Order Type: Bulk");
		}

		System.out.println("Ticket Quantity: " + ticketQuantity);
		System.out.println("Customer Address: " + customerID);
		System.out.println("Total Cost: " + salesCost);
		System.out.println("--- ---------------- ---");
		System.out.println();
	}

	// shows sales records - total sales, number of tickets sold, remaining ticket quantity
	public void showSales()
	{

	}

	// displays information about last sales transaction
	public void showLastTransaction()
	{

	}

	// store hashed transcation records from NEM transactions
}