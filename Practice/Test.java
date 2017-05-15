import java.io.*;
import java.util.Scanner;
public class Test
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the Filename:  ");
		String filename = keyboard.nextLine();
		Printwriter outputFile  = new Printwriter(filename);
	}
}