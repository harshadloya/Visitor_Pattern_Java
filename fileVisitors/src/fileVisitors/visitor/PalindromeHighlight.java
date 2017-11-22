package fileVisitors.visitor;

import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;
import fileVisitors.util.VisitorHelper;

public class PalindromeHighlight implements VisitorI
{
	@Override
	public void visit(RedBlackTree tree) 
	{
		checkPalindromeRecursively(tree.getRoot());
	}

	/**
	 * Method used to traverse the tree recursively and check if the word is Palindrome.
	 * @param root - Root Node of the Tree
	 */
	private void checkPalindromeRecursively(Node root)
	{
		if(root != null)
		{
			checkPalindromeRecursively(root.getLeft());

			VisitorHelper helper = new VisitorHelper();
			boolean isPalindrome = helper.palindromeCheck(root);

			if(isPalindrome)
			{
				root.setWord(root.getWord().toUpperCase());
			}

			checkPalindromeRecursively(root.getRight());
		}
	}
}