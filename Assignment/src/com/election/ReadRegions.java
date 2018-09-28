package com.election;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadRegions
{
		//Array list declaration for storing contestants by regions 
		public ArrayList<Character> R1=new ArrayList<Character>();
		public ArrayList<Character> R2=new ArrayList<Character>();
	
		
		public Data readRegions(int count) throws IOException
		{
			FilterData ref1=new FilterData();
			
			Data rr1=new Data();
			Data rr2=new Data();
			
			FileReader file=new FileReader("C:/Users/ASHISH/Desktop/JAVA Assignments/voting.dat");
			BufferedReader reader =new BufferedReader(file);
		
			String s=" ";
			List<Character> c1=null;
			
			String line=reader.readLine();
				while(line!=null)
				{
						if(line.contains("R"+count+"/"))
							{	
								s=s+line;		
								c1=ref1.filterRegions(s);
									switch(count)
									{
										case 1:
											R1.addAll(c1);
											rr1.setR1(R1);
											c1.clear();
											return rr1;
										case 2:
											R2.addAll(c1);
											rr2.setR2(R2);
											c1.clear();
											break;
									}
							}
				   s=" ";
				   line=reader.readLine();
				}
			reader.close();
			return rr2;
		} 

}
