package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;

public class PrintTree implements VisitorI
{
	Results outputFile;
	
	public PrintTree() 
	{
		MyLogger.writeMessage("PrintTree class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public PrintTree(Results outputFileIn)
	{
		MyLogger.writeMessage("PrintTree class paramterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		outputFile = outputFileIn;
	}
	
	@Override
	public void visit(RedBlackTree tree) 
	{
		MyLogger.writeMessage("Tree:\n", MyLogger.DebugLevel.TREE);
		printDistinctWordsRecursively(tree.getRoot());
		MyLogger.writeMessage("------------------------------------------------------------------------------------------", MyLogger.DebugLevel.TREE);
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
			{
				outputFile.storeNewResult(root.getWord());
				MyLogger.writeMessage(root.getWord(), MyLogger.DebugLevel.TREE);
			}
			printDistinctWordsRecursively(root.getRight());
		}
	}

}
