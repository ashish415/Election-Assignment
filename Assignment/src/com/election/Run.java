package com.election;

import java.io.*;

import java.util.*;

public class Run 
{

		public static void main(String args[]) throws IOException 
		{
			 
			Data d0=new Data();
			d0.processData();
		}
	
		public void displayResult(int invalidR1count, int invalidR2count, String r1winner, String r2winner, String chief,
				int x, int y, int z)
		{
			
			System.out.println("\n");
			System.out.format("Head of Region 1 is %s with a majority of %d",r1winner,x);
			System.out.format("\n"+"Head of Region 2 is %s with a majority of %d",r2winner,y);
			System.out.format("\n"+"Chief Officer of all Regions is %s with a majority of %d"+"\n",chief,z);
			System.out.println("xxxTotal Invalid votes in Region 1 are : "+invalidR1count);
			System.out.println("xxxTotal Invalid votes in Region 2 are : "+invalidR2count);
			
			
		}
}

