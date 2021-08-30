package com.dining.entity;

public class Semaphore {

	private int value;

	public Semaphore(int value)
	{
		this.value=value;
	}

	public synchronized void p()
	{
		while(value==0)
		{
			try {
				System.out.println("chopStick in use");
				wait(); 
			}catch (InterruptedException e){}
		}
		value=value-1;
	}

	public synchronized void v()
	{
		value=value+1;
		notify();
	}

}
