# 🚀 Selenium Parallel Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)
![Allure](https://img.shields.io/badge/Allure-Reporting-blue)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

Enterprise-grade Selenium automation framework built for scalable, maintainable, and thread-safe UI testing.

</div>

---

# 📌 Overview

This framework is designed using modern automation architecture principles and supports:

- ⚡ Parallel Cross-Browser Execution
- 🧵 Thread-Safe WebDriver Management
- 🧱 Page Object Model (POM)
- 📊 Allure Reporting Integration
- 📸 Automatic Screenshot Capture
- 🪵 Centralized Structured Logging
- ⚙️ Dynamic Configuration Management
- 🔥 Headless Browser Execution
- 🧪 Data-Driven Testing with TestNG
- 🏗️ Enterprise-Level Framework Design

The framework is optimized for enterprise-scale automation projects and CI/CD integration.

---

# ✨ Features

| Feature | Description |
|---|---|
| ✅ Parallel Execution | Execute tests concurrently |
| ✅ Thread-Safe Drivers | Uses `ThreadLocal<WebDriver>` |
| ✅ Multi-Browser Support | Chrome, Firefox, Edge |
| ✅ POM Architecture | Clean page abstraction |
| ✅ Allure Reporting | Rich test reporting |
| ✅ Screenshot Capture | Automatic failure screenshots |
| ✅ Dynamic Configuration | Runtime config override support |
| ✅ Structured Logging | SLF4J + Logback |
| ✅ Data-Driven Testing | TestNG `@DataProvider` |
| ✅ Headless Execution | CI/CD friendly |
| ✅ Custom Exceptions | Centralized framework handling |
| ✅ Enterprise Ready | Scalable clean architecture |

---

# 🏗️ Framework Architecture

```text
src
├── main
│   └── java
│       └── com.amalw
│           ├── base
│           ├── config
│           ├── driver
│           ├── enums
│           ├── exceptions
│           ├── listeners
│           ├── logging
│           ├── model
│           ├── pages
│           └── utils
│
├── test
│   └── java
│       └── com.amalw.tests
│
└── resources
    ├── config.properties
    ├── logback.xml
    └── testng.xml
```

---

# ⚙️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Testing Framework |
| Maven | Dependency Management |
| WebDriverManager | Driver Management |
| Allure Reports | Test Reporting |
| SLF4J | Logging API |
| Logback | Logging Framework |

---

# 📦 Maven Dependencies

```xml
<dependencies>

    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.x.x</version>
    </dependency>

    <!-- Allure -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.x.x</version>
    </dependency>

    <!-- Logging -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.x.x</version>
    </dependency>

    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.x.x</version>
    </dependency>

</dependencies>
```

---

# 🔧 Configuration

## `config.properties`

```properties
base.url=http://localhost:5000
browser=firefox
pageLoadTimeout=30
headless=true
screenshot.dir=./screenshots
```

---

# 🌐 Supported Browsers

| Browser | Supported |
|---|---|
| Chrome | ✅ |
| Firefox | ✅ |
| Edge | ✅ |

---

# 🔥 Parallel Execution

The framework fully supports:

- ✅ Method-level parallel execution
- ✅ Cross-browser execution
- ✅ Thread-safe WebDriver sessions
- ✅ Independent browser instances

Implemented using:

```java
private static final ThreadLocal<WebDriver> TLDRIVER =
        new ThreadLocal<>();
```

---

# 🧵 Benefits of ThreadLocal Driver Management

- Isolated browser sessions
- No driver collision between threads
- Safe parallel execution
- Faster execution time
- Better scalability

---

# 🧪 TestNG Parallel Configuration

## `testng.xml`

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="ParallelRegistrationSuite"
       parallel="methods"
       thread-count="12">

    <listeners>
        <listener class-name=
            "com.amalw.listeners.AllureListener"/>
    </listeners>

    <test name="ChromeTests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name=
                "com.amalw.tests.RegistrationTest"/>
        </classes>
    </test>

    <test name="FirefoxTests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name=
                "com.amalw.tests.RegistrationTest"/>
        </classes>
    </test>

    <test name="EdgeTests">
        <parameter name="browser" value="edge"/>
        <classes>
            <class name=
                "com.amalw.tests.RegistrationTest"/>
        </classes>
    </test>

</suite>
```

---

# 🚀 Running Tests

## ▶️ Run All Tests

```bash
mvn clean test
```

---

## ⚡ Run in Headless Mode

```bash
mvn clean test -Dheadless=true
```

---

## 🌐 Run Specific Browser

### Chrome

```bash
mvn clean test -Dbrowser=chrome
```

### Firefox

```bash
mvn clean test -Dbrowser=firefox
```

### Edge

```bash
mvn clean test -Dbrowser=edge
```

---

# 📊 Allure Reporting

Generate Allure results:

```bash
mvn clean test
```

Serve Allure report:

```bash
allure serve allure-results
```

Generate static Allure report:

```bash
allure generate allure-results --clean -o allure-report
```

---

# 📄 Allure Report Features

- ✅ Test Execution Timeline
- ✅ Step-Level Reporting
- ✅ Failure Screenshots
- ✅ Severity Tracking
- ✅ Epic / Feature / Story Grouping
- ✅ Parallel Execution Visibility
- ✅ Stack Trace Analysis

---

# 📸 Screenshot Capture

Screenshots are automatically captured on test failures.

## Screenshot Structure

```text
screenshots/
└── RegistrationTest/
    └── testRegistration_20260518_223001.png
```

---

# 🪵 Logging System

The framework uses:

- SLF4J
- Logback
- MDC Thread Context Logging

---

# 📄 Logging Features

- Console Logging
- Rolling File Logging
- Browser Tracking
- Thread Identification
- Daily Log Rotation
- Execution Context Logging

---

# 📁 Log Storage

```text
logs/
├── automation.log
└── archived/
```

---

# 🧩 Core Framework Components

| Component | Responsibility |
|---|---|
| `ConfigManager` | Configuration handling |
| `ConfigPrinter` | Execution configuration logging |
| `DriverFactory` | Thread-safe driver lifecycle |
| `BrowserManager` | Browser creation |
| `BasePage` | Common Selenium actions |
| `RegisterPage` | Registration page interactions |
| `UserFactory` | Test user generation |
| `ScreenshotManager` | Screenshot utility |
| `BaseTest` | Test setup & teardown |
| `AllureListener` | Reporting & screenshots |

---

# 🧱 Design Patterns Used

| Pattern | Usage |
|---|---|
| Page Object Model | Page abstraction |
| Factory Pattern | Driver & user creation |
| Singleton Pattern | Shared configuration |
| ThreadLocal Pattern | Parallel execution |
| Builder-Style Chaining | Fluent page actions |
| Utility Pattern | Reusable utilities |

---

# 🧪 Sample Test Flow

```text
1. Initialize Driver
2. Open Registration Page
3. Fill Registration Form
4. Submit Registration
5. Validate Success Message
6. Capture Screenshot on Failure
7. Generate Allure Report
8. Quit Driver
```

---

# 🧪 Sample Test Scenario

```java
@Test(dataProvider = "registrationData")
public void testRegistration(User user, Gender gender) {

    RegisterPage registerPage = new RegisterPage();

    registerPage
            .open()
            .selectGender(gender)
            .fillForm(user)
            .submit();

    Assert.assertTrue(
            registerPage.isRegistrationSuccessful());

    String confirmationMessage =
            registerPage.getConfirmationMessage();

    Assert.assertTrue(
            confirmationMessage.contains(
                    "registration completed"));
}
```

---

# 🧠 Data-Driven Testing

The framework supports parallel data-driven execution using TestNG `@DataProvider`.

```java
@DataProvider(name = "registrationData", parallel = true)
public Object[][] getRegistrationData() {
    return new Object[][] {
        {
            UserFactory.buildUser(
                "John",
                "Doe",
                "ABC",
                "Pass123!",
                "Pass123!"
            ),
            Gender.MALE
        }
    };
}
```

---

# 🛡️ Error Handling

Centralized exception handling is implemented using:

```java
FrameworkException
```

---

# ✅ Benefits of Custom Exceptions

- Cleaner stack traces
- Better debugging
- Improved maintainability
- Consistent failure reporting
- Easier root-cause analysis

---

# 📌 Enterprise-Level Capabilities

- Centralized configuration
- Dynamic runtime execution
- Parallel scalability
- Structured logging
- Failure screenshot support
- Clean modular architecture
- CI/CD ready execution
- Reusable page components
- Extensible framework structure

---

# 👨‍💻 Author

## Amal W

QA Automation Engineer

---

# ⭐ Support

If you found this framework useful, consider giving the repository a ⭐ on GitHub.
