// once ticket is sold to a customer, it cannot be transferred (resold) to another entity/person

//import org.nem.core.model.*;
//import org.nem.core.crypto.*;

public class Ticket
{
	static Boolean sold; // when instantiated, becomes true - prevents the ticket from being resold or retransferred
	static int ticketType;
	static String customerID;

	static int ticketID; // each ticket has its own unique ID, to prevent duplication and reselling

	public Ticket(String cID, int tType, double ticketPrice)
	{
		sold = true;

		customerID = cID;
		ticketType = tType;

		// if the ticketType = 0, the ticket is a regular ticket, with a regular price
		if(ticketType == 0)
		{
			System.out.println("This is a REGULAR TICKET, priced at " + ticketPrice + ".");
		}

		// if the ticketType = 1, the ticket is a bulk order ticket, with a discounted price
		else if(ticketType == 1)
		{
			System.out.println("This is a DISCOUNTED TICKET, priced at " + ticketPrice + ".");
		}

		System.out.println("Ticket ID: " + ticketID);
	}

	public int getTicketID()
	{
		return ticketID;
	}
}