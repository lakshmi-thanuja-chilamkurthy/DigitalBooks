package com.digitalbooks.book.util;

import java.util.Random;

public class BookUtil {
	public static int getSubscriptionId() {
		return  new Random().nextInt(900000) + 100000;
	}


}
