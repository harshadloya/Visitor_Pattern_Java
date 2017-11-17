package fileVisitors.visitor;

import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;

public class PrimeLength implements VisitorI
{
	boolean isPrimeLen = false;
	
	@Override
	public RedBlackTree visit(RedBlackTree tree) 
	{
		checkPrimeLengthRecursively(tree.getRoot());
		return tree;
	}
	
	/**
	 * Method used to traverse the tree recursively and check if the word's length is PRIME.
	 * @param root - Root Node of the Tree
	 */
	private void checkPrimeLengthRecursively(Node root)
	{
		if(root != null)
		{
			checkPrimeLengthRecursively(root.getLeft());
			isPrimeLen = true;
			
			int length = root.getWord().length();
			if(length > 2)
			{
				if(length % 2 == 0)
				{
					isPrimeLen = false;
				}
				
				if(isPrimeLen)
				{
					for(int x = 3; x < Math.sqrt(length); x++)
					{
						if(length % x == 0)
						{
							isPrimeLen = false;
							break;
						}
					}
				}
				
				if(isPrimeLen)
				{
					isPrimeLen = false;
					root.setWord(root.getWord()+"-PRIME");
				}
			}
			checkPrimeLengthRecursively(root.getRight());
		}
	}
}