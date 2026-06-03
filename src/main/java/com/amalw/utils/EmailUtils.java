package com.amalw.utils;

import java.util.UUID;

public final class EmailUtils {
	
	private EmailUtils() {}

	public static String generateUniqueEmail() {
		
		return "testuser_" + UUID.randomUUID().toString().replace("-", "") + "@mailinator.com";

	}
}

