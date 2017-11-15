package fileVisitors.util;


public class MyLogger
{

	/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
      DEBUG_VALUE=2 [Print to stdout everytime a line is read from input file]
      DEBUG_VALUE=1 [Print to stdout everytime a word is deleted]
      DEBUG_VALUE=0 [No output should be printed from the application, except the line "The average preference value is X.Y"]
	 */

	public static enum DebugLevel {RELEASE, WORD_DELETE, LINE_READ, THREAD_RUN, CONSTRUCTOR};

	private static DebugLevel debugLevel;


	/**
	 * Set the debug level allowing only that level messages to be printed.
	 * @param levelIn - integer value that contains the debugger level
	 */
	public static void setDebugValue (int levelIn) 
	{
		switch (levelIn) 
		{
		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
		case 3: debugLevel = DebugLevel.THREAD_RUN; break;
		case 2: debugLevel = DebugLevel.LINE_READ; break;
		case 1: debugLevel = DebugLevel.WORD_DELETE; break;
		case 0: debugLevel = DebugLevel.RELEASE; break;
		}
	}

	public static void setDebugValue (DebugLevel levelIn) 
	{
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage (String  message, DebugLevel levelIn ) 
	{
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * @return String
	 */
	public String toString() 
	{
		return "Debug Level is " + debugLevel;
	}
}