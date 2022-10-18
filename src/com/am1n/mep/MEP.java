package com.am1n.mep;

// AM1N
public class MEP
{
	public static void main(String arg[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if(arg.length > 0)
		{
			MEPMain mep = new MEPMain(arg[0]);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					mep.end();
				}
			}));
		}
	}
}
