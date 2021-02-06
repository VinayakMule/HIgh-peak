package org.btm.App;

import java.io.*;
import java.util.*;

public class Main 
{
	  public static void main(String[] args) throws Exception 
	  {
		  
	    FileInputStream fis=new FileInputStream("F:\\dummy\\Test_Case3.txt");       
	    Scanner sc=new Scanner(fis);
	    //Reading Number Of Employee From fileS
	    int employees = Integer.parseInt(sc.nextLine().split(": ")[1]);
	    sc.nextLine(); 
	    sc.nextLine(); 
	    sc.nextLine();
	    
	    //Storing All the Gifts
	    ArrayList<Item> gifts = new ArrayList<Item>();

	    while(sc.hasNextLine())  
	    {
	      String current[] = sc.nextLine().split(": ");
	      gifts.add(new Item(current[0], Integer.parseInt(current[1])));
	    }
	    sc.close();
	    //Sorting all gifts based on their cost
	    Collections.sort(gifts, new Comparator<Item>()
	    {
	      public int compare(Item a, Item b) 
	      { 
	        return a.cost - b.cost; 
	      } 
	    });
	    
	    //Calculating the Difference between gift's cost
	    int diff = gifts.get(gifts.size()-1).cost;
	    int min_index = 0;
	    for(int i=0;i<gifts.size()-employees+1;i++) 
	    {
	      int diff1 = gifts.get(employees+i-1).cost-gifts.get(i).cost;

	      if(diff1<=diff) 
	      {
	        diff = diff1;
	        min_index = i;
	      }
	    }
	    
	    
	    //Writing the output into the file
	    FileWriter fw = new FileWriter("F:\\dummy\\output3.txt");
	    fw.write("The goodies selected for distribution are:\n\n");
	    for(int i=min_index;i<min_index + employees; i++) 
	    {
	      fw.write(gifts.get(i).toString() + "\n");
	    }

	    fw.write("\nAnd the difference between the chosen goodie with highest price and the lowest price is " +diff);
		  fw.close();
	  }
	}
