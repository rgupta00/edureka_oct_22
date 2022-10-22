package com.demo;

import org.springframework.stereotype.Component;

@Component
 public class Magician {
	
	public void doMagic() {
		System.out.println("abra ka dabra...");
		sleep();
		if(1==2)
			throw new MagicianHeartAttack("call the dr now");
	}

	
	
	
	private void sleep() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
