package edu.bbq.u18.general.common.helpers;

public final class HeapInspector 
{
	private final static int KB_FACTOR = 1024;
	private final static int MB_FACTOR = (KB_FACTOR * KB_FACTOR);
	
	public final static int DISPLAY_TYPE_KB = 1;
	public final static int DISPLAY_TYPE_MB = 2;
	
	/**
	 * @param DISPLAY_TYPE
	 * @return
	 * */
	
	public static long getMaxMemory(int DISPLAY_TYPE) 
	{
		switch (DISPLAY_TYPE) 
		{
			case DISPLAY_TYPE_KB:
				return (Runtime.getRuntime().maxMemory() / KB_FACTOR);
			case DISPLAY_TYPE_MB:
				return (Runtime.getRuntime().maxMemory() / MB_FACTOR);
			default:
				return Runtime.getRuntime().maxMemory();
		}
		
	}
}
