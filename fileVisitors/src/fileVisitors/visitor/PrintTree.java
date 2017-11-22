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
	public void visit(RedBlackTree tree) 
	{
		printDistinctWordsRecursively(tree.getRoot());
		outputFile.writeScheduleToFile();
	}
	
	/**
	 * Method used by getCounts() to traverse the tree recursively and calculate the required counts.
	 * @param root - Root Node of the Tree
	 */
	private void printDistinctWordsRecursively(Node root)
	{
		if(root != null)
		{
			printDistinctWordsRecursively(root.getLeft()); 
			if(root.getWordOccurances() != 0)
				outputFile.storeNewResult(root.getWord());
			printDistinctWordsRecursively(root.getRight());
		}
	}

}
