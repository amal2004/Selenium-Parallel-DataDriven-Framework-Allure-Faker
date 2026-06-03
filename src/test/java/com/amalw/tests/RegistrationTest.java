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
public class RegistrationTest extends BaseTest {

	private static final Logger logger = FrameworkLogger.getLogger(RegistrationTest.class);
	private static final int TEST_DATA_COUNT = ConfigManager.getInt("registration.test.data.count", 5);

	@DataProvider(name = "registrationData", parallel = true)
	public Object[][] getRegistrationData() {

		Object[][] data = new Object[TEST_DATA_COUNT][2];
		
		 for (int i = 0; i < TEST_DATA_COUNT; i++) {

	            data[i][0] = UserTestDataFactory.validUser();
	            data[i][1] = UserTestDataFactory.randomGender();
	        }

	        return data;

	}


	@Test(dataProvider = "registrationData")
	@Story("Successful user registration")
    @Severity(SeverityLevel.CRITICAL)
	public void testRegistration(User user, Gender gender) {

		logger.info("Starting registration test for user: {} {}", user.getFirstName(), user.getLastName());

		RegisterPage registerPage = new RegisterPage();

		registerPage.open().selectGender(gender).fillForm(user).submit();

		Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration success message was not displayed");

		logger.info("Registration completed successfully for user: {} {}", user.getFirstName(), user.getLastName());

		Assert.assertTrue(registerPage.getConfirmationMessage().contains("registration completed"), "Did not contain expected text");
	}

}