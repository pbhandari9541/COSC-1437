public class TestMainExtended
{
	public static void main (String[] args)
	{
		for (String s: args)
        	System.out.println(s);
    }
    public static void main(int i)
    {
		System.out.println("In public static void main(int i)");
	}
	public static int main()
	{
		System.out.println("In static int main()");
		return 0;
	}
/*
	public void main(String[] args)
	{
		System.out.println("In public void main(String[] args)");
	}
	public void main(int i)
	{
		System.out.println("In public void main(int i)");
	}
	public void main()
	{
		System.out.println("In public void main()");
	}

*/
/*
	private static void main(String[] args)
	{
		System.out.println("In private static void main(String[] args)");
	}
	private static void main(int i)
	{
		System.out.println("In private static void main(int i)");
	}
	private static void main()
	{
		System.out.println("In private static void main()");
	}
*/
}