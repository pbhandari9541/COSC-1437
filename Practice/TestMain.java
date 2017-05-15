
public class TestMain
{
	/*public static void main(String[] args)
	{
		System.out.println("In public static void main(String[] args)");
        for (String s: args) {
            System.out.println(s);
        }
    }*/

//    public static int main(String[] args)		// method main(String[]) is already defined in class TestCommandLineArgument
    public static int main()
    {
		System.out.println("In public static int main()");
		return 1;
	}

    public static void main(int i)
    {
		System.out.println("In public static void main(int i)");
	}

	public void main(String[] args)	{		// method main(String[]) is already defined in class TestCommandLineArgument
		public void main()					// method main() is already defined in class TestCommandLineArgument
		public void main(int i)
   		 {
			System.out.println("In public void main(int i)");
		}
		}
}