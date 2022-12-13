package main;

import java.util.Scanner;

public class Input 
{
	public static int inputInt(Scanner scanner)
	{
		String prompt = "Choice: ";
	    System.out.print(prompt);
	    if(scanner.hasNextInt())
	            return scanner.nextInt();
	    else {
	    		System.out.println();
	            System.out.println("PLEASE ENTER A VALID OPTION");
	            System.out.println();
	            scanner.next();
	            return inputInt(scanner);
	    }
	}
}
