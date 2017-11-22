package fileVisitors.driver;

import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;
import fileVisitors.util.RedBlackTree;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;

/**
 * Class containing the main method which is the starting point of code
 * execution
 * 
 * @author hloya
 *
 */
public class Driver 
{
	/**
	 * Main method responsible for creating visitors and perform their operations.
	 * 
	 * @param args - Input given from command line which contains location of Input file, Output file and Debug Level.
	 */
	public static void main(String[] args) 
	{
		String inputFilePath = "";
		String outputFilePath = "";
		int debugVal = -1;

		if (3 == args.length) {
			inputFilePath = args[0];
			outputFilePath = args[1];

			if (args[2].matches("[0-4]")) 
			{
				debugVal = Integer.parseInt(args[2]);
				MyLogger.setDebugValue(debugVal);
			} 
			else 
			{
				System.err.println("The last parameter should be a digit in range of 0-4 specifying debug level desired");
				System.exit(1);
			}

			RedBlackTree tree = new RedBlackTree();
			PopulateVisitor popVisitor = new PopulateVisitor(inputFilePath);
			tree.accept(popVisitor);
			
			PalindromeHighlight palindromeVisitor = new PalindromeHighlight();
			tree.accept(palindromeVisitor);
			
			PrimeLength primLenVisitor = new PrimeLength();
			tree.accept(primLenVisitor);
			
			Results res = new Results(outputFilePath);
			PrintTree printTreeVisitor = new PrintTree(res);
			tree.accept(printTreeVisitor);
		} 
		else 
		{
			System.err.println("Invalid number of arguments, please recheck");
			System.exit(1);
		}
	}
	
	
}