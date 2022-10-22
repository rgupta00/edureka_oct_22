package com.demo;

import java.util.Random;

class Cal implements Runnable{
	private int val;
	private boolean isDone=false;
	
	public Cal() {
	}

	@Override
	public void run() {
		val= new Random().nextInt(10);
		isDone=true;
		synchronized (this) {
			notifyAll();
		}
	}
	public synchronized int getSum() {
		if(!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return val;
	}
}
public class Demo {
	
	public static void main(String[] args) {
		
		Cal cal=new Cal();
		Thread thread=new Thread(cal);
		thread.start();
		
		System.out.println(cal.getSum());
	}

}
