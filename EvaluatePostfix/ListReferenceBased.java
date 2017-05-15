public  class ListReferenceBased implements ListInterface
{
	private Node head;
	private int numItems;

	public ListReferenceBased()
	{
		head = null;
		numItems = 0;
	}

	public boolean isEmpty()
	{
		return (numItems ==0);
	}

	public int size()
	{
		return numItems;
	}

	public void add(int index, Object item) throws ListException
	{
		if(index>=0 && index<=size())
		{
			if(index==0)
			{
			head = new Node(item,head);
			}
			else
			{
				Node prev = find(index-1);
				Node newNode = new Node(item,prev.getNext());
				prev.setNext(newNode);
			}
			numItems++;
		}else{Exception handling;}
	}
	public Node find(int index)
	{
		Node curr = head;
		for(int i = 0;i<index;i++){
			curr = curr.getNext();
			}
		return curr;
	}

	public Object get(int index)throws ListIndexOutOfBoundsException
	{
		if(index>=0 && index<size())
		{
			Node curr = find(index);
			Object dataItem = curr.getItem();
			return dataItem;
		}
		else
		{Exception handling;}
		return -1;
	}

	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if(index>=0 && index<size())
		{
			if(index==0)
			{
				head = head.getNext();
			}
			else
			{
			Node prev = find(index-1);
			prev.setNext(prev.getNext().getNext());
			}
			numItems--;
		}
		else{Exception handling;}
	}

	public void removeAll()
	{
		head = null;
		numItems = 0;
	}
}