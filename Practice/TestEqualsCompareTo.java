public class TestEqualsCompareTo
{
	public static void main(String[] args)
	{
		String a = new String("apple");			//(01)
		String b = new String("apple");			//(02)
		String c = "banana";					//(03)
		String d = "banana";					//(04)

		String e = a;							//(05)
		String f = c;							//(06)

		System.out.println(a==b);				//(07)
		System.out.println(a==c);				//(08)
		System.out.println(c==d);				//(09)
		System.out.println(a==e);				//(10)
		System.out.println("");
		System.out.println(a.equals(b));		//(11)
		System.out.println(a.equals(c));		//(12)
		System.out.println(c.equals(d));		//(13)
		System.out.println(a.equals(e));		//(14)

		System.out.println(a.compareTo(b));		//(15)
		System.out.println(a.compareTo(c));		//(16)
		System.out.println(c.compareTo(d));		//(17)
		System.out.println(a.compareTo(e));		//(18)

	}
}