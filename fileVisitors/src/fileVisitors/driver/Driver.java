package fileVisitors.driver;

import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

/**
 * Class containing the main method which is the starting point of code
 * execution
 * 
 * @author hloya
 *
 */
public class Driver {
	/**
	 * Main method responsible for creating visitors and perform their operations.
	 * 
	 * @param args - Input given from command line which contains location of Input file, Output file and Debug Level.
	 */
	public static void main(String[] args) {
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
			} else 
			{
				
				System.err.println("The last parameter should be a digit in range of 0-4 specifying debug level desired");
				System.exit(1);
			}

			FileProcessor fileProc = new FileProcessor(inputFilePath);
			Results result = new Results(outputFilePath);
			
			result.storeNewResult("The total number of words: " + 0);
			result.storeNewResult("The total number of characters: " + 1);
			result.storeNewResult("The total number of distinct words: "+ 2);
			result.writeScheduleToFile();
			
		} else {
			System.err.println("Invalid number of arguments, please recheck");
			System.exit(1);
		}
	}
}