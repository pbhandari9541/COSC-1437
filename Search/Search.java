/*
@Title: Search
@Purpose: String processing, ArrayList, text file handling, sequential search, binary search, recursion.
@Author: Parameshor Bhandari
@Date:Sep 30, 2014
*/
import java.io.*;
import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;
import java.io.File;


public class Search
{
  public static final String TO_STOP = "-1";
  public static final int NOT_FOUND = -1;
  public static final int MAX_SIZE = 1000;

  public static int count1;
  public static int count2;
  public static int count3;


  public int sequentialSearch(ArrayList<String> array, String value)
  {
	int low = 0;
	int high = array.size()-1;
	for (int i = low; i <= high; i++){
		count1++;
		if (array.get(i).equals(value))
			return i;
	}
	return NOT_FOUND;
  } // end of sequentialSearch()

  public int binarySearch(ArrayList<String> array, String value)
  {
	int low = 0;
	int high = array.size() - 1;
	while (low <= high) {
		int mid = (low + high)/2;
		count2++;
		if (array.get(mid).compareTo(value)> 0)
		{
			high = mid - 1;
		} else if (array.get(mid).compareTo(value)< 0)
		{
			low = mid + 1;
	   	} else
			return mid;
	}
	return NOT_FOUND;
  } // end of binarySearch()


  public int binarySearch(ArrayList<String> array, int low, int high, String value)
  {
	if (low > high)
		return NOT_FOUND;
	int mid = (low + high)/2;
    count3++;
	if (array.get(mid).compareTo(value)> 0 )
	{
		return binarySearch(array, low, mid-1, value);
	} else if (array.get(mid).compareTo(value)< 0 )
	{
		return binarySearch(array, mid+1, high, value);
	} else
		return mid;
  } // end of binarySearch()



  public static void main(String[] args) throws IOException

  {
	  try
	  {
		ArrayList<String> myArrayList = new ArrayList<String>();
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter the filename: "); //get the filename
		String filename = keyboard.nextLine();
		File file = new File(filename); //open the file
		Scanner inputFile = new Scanner(file);

		while(inputFile.hasNext()) //read and add to myArrayList
		{
			String line = inputFile.nextLine();
			myArrayList.add(line);
     	}

		System.out.println(myArrayList.size()  +  "  words are populated in the instance of arraylist");

    	boolean wantToContinue = true;

    do {
		System.out.print("Type a word  to search ("+ TO_STOP + " to stop): ");
		String word2Search = keyboard.nextLine();
		if (word2Search.equals(TO_STOP))
		{
			wantToContinue = false;
		}
		else
		{
			count1 = count2 = count3 = 0;

			Search si = new Search();
			int index;

			index = si.sequentialSearch(myArrayList, word2Search);
			if (index == NOT_FOUND)
				System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
			else
				System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + index + "] (comparison=" + count1 + ").");

			index = si.binarySearch(myArrayList, word2Search);
			if (index == NOT_FOUND)
				System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
			else
				System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count2 + ").");

			index = si.binarySearch(myArrayList, 0, myArrayList.size()-1, word2Search);
			if (index == NOT_FOUND)
				System.out.println("recursive binarySearch(): " + word2Search + " is not found (comparison=" + count3 + ").");
			else
				System.out.println("recursive binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count3 + ").");
		}
	} while (wantToContinue);
  }
  catch (IOException e){}
} // end of main()
public void main() throws IOException// overloading the main method
 {
	 try
		  {
			ArrayList<String> myArrayList = new ArrayList<String>();
				Scanner keyboard = new Scanner(System.in);
				System.out.print("Enter the filename: "); //get the filename
			String filename = keyboard.nextLine();
			File file = new File(filename); //open the file
			Scanner inputFile = new Scanner(file);

			while(inputFile.hasNext()) //read and add to myArrayList
			{
				String line = inputFile.nextLine();
				myArrayList.add(line);
	     	}

			System.out.println(myArrayList.size()  +  "  words are populated in the instance of arraylist");

	    	boolean wantToContinue = true;

	    do {
			System.out.print("Type a word  to search ("+ TO_STOP + " to stop): ");
			String word2Search = keyboard.nextLine();
			if (word2Search.equals(TO_STOP))
			{
				wantToContinue = false;
			}
			else
			{
				count1 = count2 = count3 = 0;

				Search si = new Search();
				int index;

				index = si.sequentialSearch(myArrayList, word2Search);
				if (index == NOT_FOUND)
					System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
				else
					System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + index + "] (comparison=" + count1 + ").");

				index = si.binarySearch(myArrayList, word2Search);
				if (index == NOT_FOUND)
					System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
				else
					System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count2 + ").");

				index = si.binarySearch(myArrayList, 0, myArrayList.size()-1, word2Search);
				if (index == NOT_FOUND)
					System.out.println("recursive binarySearch(): " + word2Search + " is not found (comparison=" + count3 + ").");
				else
					System.out.println("recursive binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count3 + ").");
			}
		} while (wantToContinue);
	  }
  catch (IOException e){}
 }
} // end of Search