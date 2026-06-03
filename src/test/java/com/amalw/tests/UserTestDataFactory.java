package com.amalw.tests;

import com.amalw.datagenerator.FakeDataGenerator;
import com.amalw.enums.Gender;
import com.amalw.model.User;
import com.amalw.utils.EmailUtils;

import net.datafaker.Faker;

public final class UserTestDataFactory {
	
	 private static final Faker FAKER = FakeDataGenerator.getFaker();

	    private UserTestDataFactory() {}

	    // =========================
	    // BASE VALID USER
	    // =========================

	    public static User validUser() {
	        String password = generatePassword();

	        return User.builder()
	                .firstName(FAKER.name().firstName())
	                .lastName(FAKER.name().lastName())
	                .email(EmailUtils.generateUniqueEmail())
	                .company(FAKER.company().name())
	                .password(password)
	                .confirmPassword(password)
	                .build();
	    }

	    // =========================
	    // NEGATIVE TEST CASES
	    // =========================

	    public static User invalidEmailUser() {
	        return validUser().toBuilder()
	                .email("invalid-email")
	                .build();
	    }

	    public static User emptyEmailUser() {
	        return validUser().toBuilder()
	                .email("")
	                .build();
	    }

	    public static User passwordMismatchUser() {
	        return validUser().toBuilder()
	                .confirmPassword("WrongPassword123")
	                .build();
	    }

	    public static User weakPasswordUser() {
	        return validUser().toBuilder()
	                .password("123")
	                .confirmPassword("123")
	                .build();
	    }

	    public static User emptyFirstNameUser() {
	        return validUser().toBuilder()
	                .firstName("")
	                .build();
	    }

	    public static User longFirstNameUser() {
	        return validUser().toBuilder()
	                .firstName(FAKER.lorem().characters(300))
	                .build();
	    }

	    public static User sqlInjectionUser() {
	        return validUser().toBuilder()
	                .firstName("' OR '1'='1")
	                .build();
	    }

	    public static User xssUser() {
	        return validUser().toBuilder()
	                .firstName("<script>alert('xss')</script>")
	                .build();
	    }

	    // =========================
	    // GENDER GENERATION
	    // =========================

	    public static Gender randomGender() {
	        return FAKER.bool().bool() ? Gender.MALE : Gender.FEMALE;
	    }

	    // =========================
	    // PRIVATE HELPERS
	    // =========================

	    private static String generatePassword() {
	        return FAKER.internet().password(8, 12, true, true, true);
	    }

}
