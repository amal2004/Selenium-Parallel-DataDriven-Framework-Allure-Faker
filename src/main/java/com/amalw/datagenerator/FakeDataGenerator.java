package com.amalw.datagenerator;

import java.util.Locale;

import net.datafaker.Faker;

public class FakeDataGenerator {

	private static final ThreadLocal<Faker> FAKER = ThreadLocal.withInitial(() -> new Faker(new Locale("en-US")));

	private FakeDataGenerator() {
	}

	public static Faker getFaker() {
		return FAKER.get();
	}
}
