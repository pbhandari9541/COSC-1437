
public class IsPalindrome
{
	public static boolean isPal(String str)
	{

		StackListBased myStack  = new StackListBased();
		QueueListBased myQueue = new QueueListBased();
		for (int i = 0;i< str.length();i++){
			String character = str.substring(i, i + 1);
			myQueue.enqueue(character);
			myStack.push(character);
		}
		while(!myQueue.isEmpty())
		{
			Object queueFront = myQueue.dequeue();
			Object stackFront = myStack.pop();
			if(!queueFront.equals(stackFront))
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[]args)
	{	String myString  = new String();
		String s  = " Nebelregennegerleben";
		String trimmedS = s.trim();
		String upperS = trimmedS.toUpperCase();
		if (isPal(upperS)){
			System.out.println("Congratulation!! the word is palindrome");
		}else{
			System.out.println("Sorry!! it's not palindrome");
		}
		String a  = " Character";
		String trimmedA = a.trim();
		String upperA = trimmedA.toUpperCase();
		if (isPal(upperA)){
			System.out.println("Congratulation!! the word is palindrome");
		}else{
			System.out.println("Sorry!! it's not palindrome");
		}
	}
}