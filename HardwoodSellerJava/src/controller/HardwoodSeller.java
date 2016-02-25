import java.io.*;
import java.util.*;
/**
 * 
 */
package controller;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller
{

	/**
	 * @param args
	 */
	 
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String path = scn.nextLine();
		readInputFile(path);
	}
	
	public void readInputFile(String inputFilePath)
	{
		Scanner scn = new Scanner(inputFilePath);
		String line1 = scn.nextLine();
		int delim = line1.indexOf(';');
		String name = line1.substring(0, delim);
		line1 = line1.substring(delim+1);
		delim = line1.indexOf(';');
		String address = line1.substring(0, delim);
		String date = line1.substring(delim+1);
		String line2 = scn.nextLine();
		String[] woods = new String[6];
		int[] amnt = new int[6];
		int x = 0;
		while(delim==line2.length())
		{
			delim = line2.indexOf(':');
			String wood = line2.substring(0,delim);
			line2 = line2.substring(delim+1);
			delim = line2.indexOf(';');
			if(delim == -1) delim = line2.length();
			int amt = Integer.parseInt(line2.substring(0,delim));
			woods[x] = wood;
			amnt[x] = amt;
			x++;
		}
		double[] prices = new double[6];
		for(int q = 0; q < 6; q++)
		{
			double base;
			if(woods[q].equals("Cherry"))
			{
				base = 5.95;
			}
			else if(woods[q].equals("Curly Maple"))
			{
				base = 6.00;
			}
			else if(woods[q].equals("Genuine Mahogany"))
			{
				base = 9.60;
			}
			else if(woods[q].equals("Wenge"))
			{
				base = 22.35;
			}
			else if(woods[q].equals("White Oak"))
			{
				base = 6.70;
			}
			else if(woods[q].equals("Sawdust"))
			{
				base = 1.50;
			}
			prices[q] = base * amnt[q];
		}
		double[] times = new double[6];
		for(int q = 0; q < 6; q++)
		{
			double base;
			double mult;
			if(woods[q].equals("Cherry"))
			{
				base = 2.5;
			}
			else if(woods[q].equals("Curly Maple"))
			{
				base = 1.5;
			}
			else if(woods[q].equals("Genuine Mahogany"))
			{
				base = 3;
			}
			else if(woods[q].equals("Wenge"))
			{
				base = 5;
			}
			else if(woods[q].equals("White Oak"))
			{
				base = 2.3;
			}
			else if(woods[q].equals("Sawdust"))
			{
				base = 1;
			}
			if(amnt[q] < 101)
			{
				mult = 1;
			}
			else if(amnt[q] < 201)
			{
				mult = 2;
			}
			else if(amnt[q] < 301)
			{
				mult = 3;
			}
			else if(amnt[q] < 401)
			{
				mult = 4;
			}
			else if(amnt[q] < 501)
			{
				mult = 5;
			}
			else if(amnt[q] < 1001)
			{
				mult = 5.5;
			}
			times[q] = mult*base;
		}
		double time = times[0];
		for(int q = 1; q < 6; q++)
		{
			if(times[q] > time)
			{
				time = times[q];
			}
		}
		System.out.println(name);
		System.out.println(address);
		for(int q = 0; q < 6; q++)
		{
			if(woods[q]!=null)
			{
				System.out.println(amnt[q] + " of " + woods[q] + " for " + prices[q]);
			}
		}
		System.out.println("Estimated delivery time: " + time);
	}
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
