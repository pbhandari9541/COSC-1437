// ********************************************************
// Reference-based implementation of the ADT Sorted List.
// *********************************************************
 /**
 * class SortedListReferenceBased
 *
 *    A class that implements the SortedListInterface using a linked list
 *
 */
//import java.io.*;
public class SortedStringListReferenceBased implements SortedStringListInterface
{
	private Node head;
  	private int numItems;  // number of items in list


  	public SortedStringListReferenceBased()
  	// creates an empty list
  	{
		head = null;
		numItems = 0;
  	}  // end default constructor

  	public boolean isEmpty()
  	// Determines whether a list is empty
  	{
		return (numItems==0);
  	} // end isEmpty

  	public int size()
  	// Returns the number of items that are in a list
  	{
  		return numItems;
  	}  // end size

  	public void removeAll()
  	// Removes all the items in the list
  	{
		head = null;
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
			if(index>=0 && index<= size())
			{
				if (index==0)
					head = new Node(item,head);
				else
				{
					Node prev = find(index-1);
					Node newNode = new Node(item,prev.getNext());
					prev.setNext(newNode);
				}
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
		if (index >= numItems)
		{
			throw new ListIndexOutOfBoundsException(index + " is an invalid index");
		}
		Node curr = find(index);
		return (String)curr.getItem();
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
			if(index >= 0 && index <size())
			{
				if (index==0)
					head = head.getNext();

				else
				{

				Node prev = find(index-1);
				Node curr = prev.getNext();
				prev.setNext(curr.getNext());
				}
			numItems--;
			}


		}
		catch(Exception e)
		{
			throw new ListException("Remove " + item.toString() + " from List failed:  " + e.toString());
		}
	}
	public Node find(int index)
	{
	Node curr = head;
	for(int i = 0;i<index;i++){
		curr = curr.getNext();
		}
	return curr;
	}

	public int locateIndexToInsert(String item)
	{
	Node prev = head;
	for (int i = 0;i<size();i++)
			{
				if (item.compareTo((String)prev.getItem()) < 0 )
				{
					 return i;
				}
			prev = prev.getNext();
			}
	return size();
	}

  	public int locateIndex(String item)
  	// Returns the position where the item belongs or exists in a sorted list;
  	// item and the list are unchanged.
  	{
		// YOUR CODE WILL BE HERE...
	int i = 0;
	Node prev = head;
	while(prev !=null)
		{
			if (item.equals((String)prev.getItem()))

				return i;

			prev = prev.getNext();
			i++;
	}
	return -1 ;
	}

}  // end SortedListReferenceBased


