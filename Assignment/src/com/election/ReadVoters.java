package com.election;

import java.io.*;
import java.util.HashMap;

public class ReadVoters 
{
	// HashMaps for storing votes by regions
	HashMap<Integer, String> R1votes = new HashMap<Integer, String>();
	HashMap<Integer, String> R2votes = new HashMap<Integer, String>();
	
	// For Data Cleaning
	HashMap<Integer, String> temp = new HashMap<Integer, String>();
	HashMap<Integer, String> temp1 = new HashMap<Integer, String>();
	
	// For InvalidVotes 
	HashMap<Integer,String> invalid=new HashMap<Integer,String>();

	public Data readVoters(int count) throws IOException 
	{
		Data rv1 = new Data();
		Data rv2 = new Data();
		
		FilterData data = new FilterData();
		VoteResults votes= new VoteResults();

		FileReader file = new FileReader("C:/Users/ASHISH/Desktop/JAVA Assignments/voting.dat");
		BufferedReader reader = new BufferedReader(file);

		String s1 = "";
		int count1 = count + 1;
		int flag=0;

		String label = "R" + count;
		String label1 = "R" + count1;

		String line = reader.readLine();

		flow: while (line != null) 
		{
			if ((line.length() >= 2) && !(line.contains("/"))) 
			{
				if (line.contains(label)) 
				{
					line = reader.readLine();
					while (!(line.contains(label1)) || line.contains("&&")) 
					{
						if (line.contains("&&")) 
						{
							file.close();
							break flow;
						}
						s1 = s1 + line;
						//invalid=data.checkVote(label, s1);
						flag=flag+1;							// Total Votes Per Region
						temp = data.filterVotes(s1,count);
						temp1.putAll(temp);
						temp.clear();
						s1 = "";
						line = reader.readLine();
					}
					if (line.contains(label1)) 
					{
						file.close();
						break flow;
					}
				} 
				else if (!(line.contains(label))) 
				{
					line = reader.readLine();
				}
			} 
			else 
			{

				line = reader.readLine();
			}
		}

		switch (count) 
		{
		case 1:
			votes.totalVotes(flag, count);
			R1votes.putAll(temp1);
			rv1.setR1votes(R1votes);
			temp1.clear();
			return rv1;
		case 2:
			votes.totalVotes(flag, count);
			R2votes.putAll(temp1);
			rv2.setR2votes(R2votes);
			temp1.clear();
			break;
		}
		return rv2;

	}
}
