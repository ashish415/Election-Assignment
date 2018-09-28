package com.election;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilterData 
{
	
		HashMap<Integer,String> InvalidR1=new HashMap<Integer,String>();
		HashMap<Integer,String> InvalidR2=new HashMap<Integer,String>();
		
		public ArrayList<Character> filterRegions(String p)				   // Read the Region Contestants line by line
		{
			FilterData assign=new FilterData();
			
			ArrayList<Character> temp=new ArrayList<Character>();
			temp.clear();
			p=p.substring(4);
		
			for(int i=0;i<p.length();i++)
			{
				char p1=p.charAt(i);
				temp.add(p1);
				i=i+1;
			}
			return temp;
			
		}
		
		public HashMap<Integer,String> filterVotes(String p1,int count)    //Read the Votes Regionally line by line
		{
			HashMap<Integer,String> votes=new HashMap<Integer,String>();
			
			FilterData fd=new FilterData();
			
			String voter_id=p1.replaceAll("[^0-9]","");
			String voter_list=p1.replaceAll("[^A-Z]","");
			if(voter_list.length()==0 || voter_list.length()>3)			   //Take the Invalid Vote Condition 2
			{
				if(voter_list.length()==0)
				{
					voter_list="NULL";
				}
				fd.checkVote(voter_id, voter_list,count);
			}
			else
			{
				int id=Integer.parseInt(voter_id);					       //Take Each and every vote one by one
				votes.put(id,voter_list);
			}
			return votes;
		}
		
		
		public void checkVote(String id,String votes,int count)	           //Store the Invalid Vote Condition 2 
		{
			//VoteValidity vv0=new VoteValidity();
			//VoteValidity vv1=new VoteValidity();
			int voter_id=Integer.parseInt(id);
			String votes_list=votes.replace("", " ").trim();
			
			switch(count)
			{
			case 1:
				InvalidR1.put(voter_id, votes_list);
				System.out.println("xxxInvalid Vote in Region1:: "+InvalidR1);
				break;
			case 2:
				InvalidR2.put(voter_id, votes_list);
				System.out.println("xxxInvalid Vote in Region2:: "+InvalidR2);
				break;
			}
			
		}
}








