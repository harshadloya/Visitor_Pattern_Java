package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;

public class PopulateVisitor implements VisitorI
{
	String inputFile;
	
	public PopulateVisitor() 
	{
		MyLogger.writeMessage("PopulateVisitor class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public PopulateVisitor(String inputFileIn)
	{
		MyLogger.writeMessage("PopulateVisitor class paramterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		inputFile = inputFileIn;
	}
	
	@Override
	public void visit(RedBlackTree tree)
	{
		FileProcessor inputFileProc = new FileProcessor(inputFile);
		
		String line = "";
		String temp[];

		while((line = inputFileProc.readLine("")) != null)
		{
			//remove leading or trailing whitespaces if any
			line = line.trim();
			temp = line.split("\\s+");

			Node node_orig = null;
			for(int i = 0; i < temp.length; i++)
			{
				if(null != temp[i] && temp[i].compareTo(" ") != 0 && temp[i].compareTo("") != 0)
				{
					try
					{
						//check if node with that word string already exists
						node_orig = tree.search(tree.getRoot(), temp[i]);
						node_orig.setWordOccurances(node_orig.getWordOccurances() + 1);
					}
					catch(IndexOutOfBoundsException | NullPointerException e)
					{
						//else create a new node
						node_orig = new Node();
						node_orig.setWord(temp[i]);
						node_orig.setWordOccurances(1);
					}
					tree.insert(node_orig);
				}
			}
		}
	}
}
