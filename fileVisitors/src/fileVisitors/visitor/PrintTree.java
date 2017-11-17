package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;

public class PrintTree implements VisitorI
{
	Results outputFile;
	
	public PrintTree(Results outputFileIn)
	{
		outputFile = outputFileIn;
	}
	
	@Override
	public RedBlackTree visit(RedBlackTree tree) 
	{
		/*Results result = new Results(outputFilePath);
		
		result.storeNewResult("The total number of words: " + 0);
		result.storeNewResult("The total number of characters: " + 1);
		result.storeNewResult("The total number of distinct words: "+ 2);
		result.writeScheduleToFile();*/
		
		calculateCountsRecursively(tree.getRoot());
		outputFile.writeScheduleToFile();
		return tree;
	}
	
	/**
	 * Method used by getCounts() to traverse the tree recursively and calculate the required counts.
	 * @param root - Root Node of the Tree
	 */
	private void calculateCountsRecursively(Node root)
	{
		if(root != null)
		{
			calculateCountsRecursively(root.getLeft()); 
			if(root.getWordOccurances() != 0)
				outputFile.storeNewResult(root.getWord());
			calculateCountsRecursively(root.getRight());
		}
	}

}
