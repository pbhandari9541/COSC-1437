import java.util.Scanner;
import java.util.StringTokenizer;


public class EvaluatePostfix
{
	private static String getExpressionFromKeyboard()
	{
		Scanner sc = new Scanner(System.in);
//		System.out.print("What is your postfix arithmetic expression? ");
		System.out.print("Type your postfix arithmetic expression (e.g., 10 20 30 / *): ");
		return sc.nextLine();
	}


//==============================================
// TASK#1
//==============================================
// Returns if the given string is one of the four binary operators: +, -, /, and *
// Otherwise, return false;
	private static boolean isOperator(String s)
	{
		if (s.contains("+")){
			return true;

		} else if(s.contains("-")){
			return true;

		} else if (s.contains("/")){
			return true;

		} else if (s.contains("*")){
			return true;

		} else{
			return false;
		}
	}


//==============================================
// TASK#2
//==============================================
// Returns result of binary operation, given two double values and a binary operator.
// Assume that only a valid operator is passed (i.e., +, -, /, or *)
	private static double evaluateOperation(double operand1, double operand2, String operator)
	{
		double result;
		if (operator.contains("+")){
			result = operand1 + operand2;
			return result;

		} else if (operator.contains("-")){
			result = operand1 - operand2;
			return result;

		} else if (operator.contains("/")){
			result = operand1 / operand2;
			return result;

		} else if(operator.contains("*")){
			result = operand1 * operand2;
			return result;
		}
		return -1;
	}


//==============================================
// TASK#3
// Refer to "Evaluating Postfix Expression" in handout_chap7.pdf.
//==============================================
	private static Double evaluateExpression(String expression) throws StackException
	{
// ALSO, THIS VERSION WORKS FINE.
//		StackArrayBased myStack = new StackArrayBased();
//		StackReferenceBased myStack = new StackReferenceBased();
		StackListBased myStack = new StackListBased();


/*
// ALSO, THIS VERSION TOKENIZES THE GIVEN STRING, TOO.
		String [] tokens = str.split(" ");
		for (String s : tokens)
			System.out.println(s);
*/
		StringTokenizer st = new StringTokenizer(expression);

		while (st.hasMoreTokens()){
			String s = st.nextToken();
			if (isOperator(s)) {
				//=============================
				// YOUR CODE GOES HERE...
				//=============================
				double operand1,operand2,result;
				if(!myStack.isEmpty()){
					operand2 = Double.parseDouble((String)myStack.pop());
					if(!myStack.isEmpty()){
						operand1 = Double.parseDouble((String)myStack.pop());
						result = evaluateOperation(operand1,operand2,s);
						myStack.push(Double.toString(result));
					}else{
						//System.out.println("error");
						break;
					}

				}else{
					//System.out.println("error");
					break;
				}

			} else {
				//=============================
				// YOUR CODE GOES HERE...
				//=============================
				myStack.push(s);

			}
		}
		if(!myStack.isEmpty()){
			Double b = Double.valueOf(myStack.pop().toString());
			if(myStack.isEmpty()){
				return b;
			}else{
				//System.out.println("error");
			}

		}else{
			//System.out.println("error");
		}
		return null;
	}


	public static void main(String[] args)
	{
		String str = getExpressionFromKeyboard();

		Double result = evaluateExpression(str);

		if (result != null)
			System.out.println(str + " = " + result);
		else
			System.out.println("Error: Invalid postfix expression...\n" + str);

  	} // end main


} // end EvaluatePostFix