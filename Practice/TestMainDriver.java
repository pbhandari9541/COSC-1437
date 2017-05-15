public class TestMainDriver
{
	public static void main (String[] args)
	{
        for (String s: args) {
            System.out.println(s);
        }

		TestMain.main(args);
		TestMain.main(100);

		TestMain tm = new TestMain();


    }

}