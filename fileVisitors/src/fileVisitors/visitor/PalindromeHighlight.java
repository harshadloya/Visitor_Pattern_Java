package fileVisitors.visitor;

import fileVisitors.util.Node;
import fileVisitors.util.RedBlackTree;

public class PalindromeHighlight implements VisitorI
{
	boolean isPalindrome = false;
	
	@Override
	public RedBlackTree visit(RedBlackTree tree) 
	{
		checkPalindromeRecursively(tree.getRoot());
		return tree;
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
			
			isPalindrome = true;
			
			int length = root.getWord().length();
			if(length > 3)
			{
				for(int x = 0; x < length/2; x++)
				{
					if(root.getWord().charAt(x) != root.getWord().charAt(length-x-1))
					{
						isPalindrome = false;
						break;
					}
				}	
				if(isPalindrome)
				{
					isPalindrome = false;
					root.setWord(root.getWord().toUpperCase());
				}
			}
			checkPalindromeRecursively(root.getRight());
		}
	}
}
