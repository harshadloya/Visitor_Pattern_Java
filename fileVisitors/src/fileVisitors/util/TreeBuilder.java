package fileVisitors.util;

import fileVisitors.visitor.VisitorI;

public class TreeBuilder 
{
	private RedBlackTree localTree;
	
	public TreeBuilder() 
	{
		localTree = new RedBlackTree();
	}

	public void accept(VisitorI visitor)
	{
		visitor.visit(localTree);
	}
}
