package com.sp.spmain.utility;

import java.util.Random;

public class Utility {

	public static String getRandomNumber() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999);
	    return String.format("%04d", number);
	}
}
