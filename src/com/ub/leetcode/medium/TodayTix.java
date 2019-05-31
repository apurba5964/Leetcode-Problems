package com.ub.leetcode.medium;

import java.util.ArrayList;

public class TodayTix {

	public static void main(String[] args) {
		//ticketsAvailable is the number of tickets currently available
		int ticketsAvailable = 5;
		int ticketsBought = 4;
		int sizeOfList = 0;
		
		int numberOfWinners = 3;//maximum number of winners from the list
		
		
		//We add all lotteryTickets Id to lotteryTickets list.
		//The size of the list will minimum of either number of ticketsAvailable
		//or the total number of tickets bought whichever is smaller
		//If the ticketsBought is greater we pick the top 50 tickets from the list
		//50 is the number of tickets available here
		//ArrayList maintains the FIFO order
		if(ticketsAvailable>ticketsBought)
			sizeOfList=ticketsBought;
		else
			sizeOfList=ticketsAvailable;
		ArrayList<Integer> lotteryTickets = new ArrayList<>(sizeOfList);
		lotteryTickets.add(1234);
		lotteryTickets.add(4567);
		lotteryTickets.add(8976);
		lotteryTickets.add(4353);
		
		ArrayList<Integer> winnersList = new ArrayList<>(numberOfWinners);//This list contains the index
		//of the winners which is then used to get ticketId from lotteryTickets list.
		
		int randomIndex;

	    for (int i = 0; i < numberOfWinners; i++) {
	    	
	    	randomIndex = (int) (Math.random() * sizeOfList); // Random number created here.
	        for (int j = 0; j < i; j++) {
	            if (winnersList.get(j) == randomIndex) // Here, we check if same random number generated before.
	            {
	            	randomIndex = (int) (Math.random() * ticketsAvailable);
	                j = -1; // If random number is same, another number generated we restart the loop
	            }

	        }
	        winnersList.add(randomIndex);
	    }

	    System.out.println("Winners index List");
	    for (int i = 0; i < winnersList.size(); i++)
	    	System.out.print(winnersList.get(i) + " ");
	    
	    System.out.println("\nWinners TicketId ");
	    for (int i = 0; i < winnersList.size(); i++)
	    	System.out.print(lotteryTickets.get(winnersList.get(i)) + " ");

	    
		
	}
	
	
	
}
