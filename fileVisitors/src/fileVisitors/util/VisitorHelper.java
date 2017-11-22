package fileVisitors.util;

public class VisitorHelper 
{

	public boolean palindromeCheck(Node node)
	{
		int length = node.getWord().length();
		if(length > 3)
		{
			for(int x = 0; x < length/2; x++)
			{
				if(node.getWord().toLowerCase().charAt(x) != node.getWord().toLowerCase().charAt(length-x-1))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean primeLengthCheck(Node node)
	{
		int length = node.getWord().length();
		if(length >= 2)
		{
			if(length != 2 && length % 2 == 0)
			{
				return false;
			}

			for(int x = 3; x < Math.sqrt(length); x++)
			{
				if(length % x == 0)
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
}