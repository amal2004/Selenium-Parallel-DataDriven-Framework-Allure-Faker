package com.amalw.base;

import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.amalw.config.ConfigPrinter;
import com.amalw.driver.DriverFactory;
import com.amalw.logging.FrameworkLogger;

import io.qameta.allure.Allure;



/* BaseTest is the foundation for all test classes. All test classes extend the BaseTest */

public class BaseTest {
	
	private static final Logger LOGGER=FrameworkLogger.getLogger(BaseTest.class);

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
	    ConfigPrinter.logExecutionConfiguration();
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws Exception {
		
		Allure.step("===== TEST SETUP STARTED =====");
		LOGGER.info("Initializing test execution | browser={}", browser);
		
		try {
			
			DriverFactory.initDriver(browser);
			LOGGER.info("Driver initialization completed successfully");
			
		} catch (Exception e) {
			LOGGER.error("Test setup failed", e);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		LOGGER.info("========== TEST TEARDOWN STARTED ==========");

		try {
			DriverFactory.quitDriver();
			LOGGER.info("Driver cleanup completed successfully");

		} catch (Exception e) {
			LOGGER.error("Error during test teardown", e);
		}

	}

}
