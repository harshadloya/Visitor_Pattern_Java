package fileVisitors.visitor;

import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;
import fileVisitors.util.VisitorHelper;

public class PrimeLength implements VisitorI
{
	boolean isPrimeLen = false;

	@Override
	public void visit(RedBlackTree tree) 
	{
		checkPrimeLengthRecursively(tree.getRoot());
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
			
			VisitorHelper helper = new VisitorHelper();
			boolean isPrimeLen = helper.primeLengthCheck(root);

			if(isPrimeLen)
			{
				root.setWord(root.getWord()+"-PRIME");
			}
			checkPrimeLengthRecursively(root.getRight());
		}
	}
}