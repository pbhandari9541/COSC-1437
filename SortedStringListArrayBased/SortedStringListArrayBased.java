// ********************************************************
// Array-based implementation of the ADT Sorted List.
// *********************************************************
 /**
 * class SortedStringListArrayBased
 *
 *    A class that implements the SortedListInterface using an array
 *
 */

public class SortedStringListArrayBased implements SortedStringListInterface
{
	private static final int MAX_LIST = 50;
	private String[] items;	     // a reference to an array of String objects
	private int numItems;  	     // number of items in list


  	public SortedStringListArrayBased()
  	// creates an empty list
  	{
		items = new String[MAX_LIST];
		numItems = 0;

  	}  // end default constructor

  	public boolean isEmpty()
  	// Determines whether a list is empty
  	{

		return (numItems == 0);
  	} // end isEmpty

  	public int size()
  	// Returns the number of items that are in a list
  	{
  		return numItems;
  	}  // end size

  	public void removeAll()
  	// Removes all the items in the list
  	{
		items = new String[MAX_LIST];
		numItems = 0;

  	} // end removeAll

  	public void add(String item) throws ListException
  	// Inserts item into its proper position in a sorted list
  	// Throws an exception if the item connot be placed on the list
  	{
		try
		{
			// YOUR CODE WILL BE HERE...
			// DEFINE ANY HELPER METHOD(S) AND CALL IT/THEM, IF YOU NEED ANY.

				int index = locateIndexToInsert(item);
				{
					for(int p = size()-1;p >= index;p--)
					{
						items[p+1] = items[p];

					}
					items[index] = item;
					numItems++;
				}
		}
		catch(Exception e)
		{
			throw new ListException("Add to List failed:  " + e.toString());
		}

	}

  	public String get(int index) throws ListIndexOutOfBoundsException
  	// Retrieves the item at position index of a sorted list, if 0 <= index < size().
  	// The list is left unchanged by this operation.
  	// Throws an exception when index is out of range.
  	{
		if (index < 0 || index >= numItems)
		{
			throw new ListIndexOutOfBoundsException(index + " is an invalid index");
		}
		return items[index];

	}

  	public void remove(String item) throws ListException
  	// Removes the item from a sorted list.
  	// Throws an exception if the item is not found.
  	{
		try
		{
			// YOUR CODE WILL BE HERE...
			// REQUIREMENT: USE "locateIndex(String item)" method.

					int index = locateIndex(item);
					if (index!=-1)
					{
					for (int p = index+1; p < size();p++)
							{
								items[p-1] = items[p];
							}
						numItems--;
					}
					else
					{
					System.out.print("item is not on the list\n");
					}
  		}
		catch(Exception e)
		{
			throw new ListException("Remove " + item.toString() + " from List failed:  " + e.toString());
		}
	}
	public int locateIndexToInsert(String item)
	{
		for (int i = 0;i<size();i++)
		{
			if (items[i].compareTo(item) > 0 )
			{
				 return i;
			}
		}

	return size();
	}
  	public int locateIndex(String item)
  	// Returns the position (i.e., index) where the item belongs or exists in a sorted list;
  	// Otherwise, it returns -1.
  	// NOTE: (1) "locateIndex(String item)" does the same operation that "sequentialSearch" does.
  	//       (2) It is completely implemented; thus, you can just use this code as it is given.
  	{
		for (int i = 0; i < size(); i++)
			if (items[i].equals(item))
				return i;
		return -1;
	}


	public String toString()
	{
		String str = new String();
		for (int i = 0; i <size();i++)
        {
			 str += items[i] + ',';
	    }
		return str;
	}

}  // end SortedStringListArrayBased
