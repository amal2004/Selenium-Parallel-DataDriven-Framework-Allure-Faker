package com.amalw.tests;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amalw.base.BaseTest;
import com.amalw.config.ConfigManager;
import com.amalw.enums.Gender;
import com.amalw.logging.FrameworkLogger;
import com.amalw.model.User;
import com.amalw.pages.RegisterPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/*
 * RegistrationTest validates user registration
 * functionality using multiple datasets.
 */
@Epic("User Management")
@Feature("Registration")
public class RegistrationNegativeTest extends BaseTest {

	private static final Logger logger = FrameworkLogger.getLogger(RegistrationNegativeTest.class);

	@DataProvider(name = "invalidRegistrationData", parallel = true)
	public Object[][] invalidRegistrationData() {


		return new Object[][] {

				{ UserTestDataFactory.invalidEmailUser(), Gender.MALE, "Please enter a valid email address." },

				{ UserTestDataFactory.emptyEmailUser(), Gender.FEMALE, "Email is required" },

				{ UserTestDataFactory.passwordMismatchUser(), Gender.MALE, "The password and confirmation password do not match." },
						
				{ UserTestDataFactory.weakPasswordUser(), Gender.FEMALE, "Password must meet the following rules" } };
	}

	@Test(dataProvider = "invalidRegistrationData")
	@Story("Successful user registration")
    @Severity(SeverityLevel.CRITICAL)
	public void testinvalidRegistrationData(User user, Gender gender, String expectedError) {

		logger.info("Starting registration test for user: {} {}", user.getFirstName(), user.getLastName());

		RegisterPage registerPage = new RegisterPage();

		registerPage.open().selectGender(gender).fillForm(user).submit();

		String actualError = registerPage.getValidationErrorMessage();
		Assert.assertTrue(actualError.contains(expectedError), "Expected error not found. Actual: " + actualError);

	}

}