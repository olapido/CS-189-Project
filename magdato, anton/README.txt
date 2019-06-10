MAGDATO, Enzo Anton P.

FINAL PROJECT: TICKET STORE

TO LAUNCH:
-Make sure that NEM NanoWallet is installed and the wallet (testnet) is set-up and logged-in
-Compile "TicketStore.java"
-Run "TicketStore.java" in command prompt or terminal

This ticket store, implemented using NEM and Java, is an online ticket store that sells tickets for select events.
This ticket store was designed to prevent ticket reselling (and 'scalping') and fake/duplicate tickets.
Each ticket in this store has its own unique ticket ID to prevent ticket reselling (and 'scalping') and fake/duplicate tickets.
Once a ticket is sold and transferred, it cannot be transferred again, to prevent reselling.

Once launched, the ticket store will ask the customer for the quantity of tickets that he/she will order.

In a transaction, if the quantity of tickets ordered is less than 5, this order will be classified as a regular order. Each ticket in the order will be considered a regular ticket.
If the quantity of tickets ordered is 5 or more, the order will be classified as a bulk order. Each ticket in the order will be considered a discounted (bulk) ticket.

The price for a regular ticket is 10.00 XEM
For bulk orders, each ticket has a 10% discount, making the price for each ticket 9.00 XEM

After specifying the quantity of tickets in the transaction, the ticket store will ask for the customer's NEM address.

After making a transaction, the customer may choose to make another order, print an official digital receipt of the transaction, or terminate the program.

This ticket store application will benefit entities who deal with the events market (which includes concerts, live shows, live games, conferences, seminars, etc.) and those who pay to attend these events. With this ticket store, customers will be protected from entities that resell or scalp (resell tickets at a price higher than the original cost), or duplicate or sell fake tickets for these events. 

Also, the ticket vendor can also monitor and keep track of all the tickets sold and the customers who purchased these tickets. Because each ticket has its own unique ID, it cannot be duplicated, and duplicated tickets may be easily identified.

A blockchain is needed in this application because this ticket store involves multiple transactions and multiple ticket customers. By using a decentralised blockchain, the ticket store can keep track of the transactions that occur within the system, the tickets that get sold and transferred, and the customers who purchased these tickets.