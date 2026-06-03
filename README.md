# 🚀 Selenium Parallel Data Driven Automation Framework with Faker

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge\&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red?style=for-the-badge)
![Allure](https://img.shields.io/badge/Allure-Reporting-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge\&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

## ✨ Enterprise-Grade Selenium Automation Framework ✨

Scalable • Thread-Safe • Parallel • Maintainable • CI/CD Ready

</div>

---

# 📌 Overview

A modern Selenium automation framework built using enterprise automation best practices and clean architecture principles.

The framework is designed for:

* ⚡ Parallel Cross-Browser Execution
* 🧵 Thread-Safe WebDriver Management
* 🧱 Page Object Model (POM)
* 📊 Allure Reporting Integration
* 📸 Automatic Screenshot Capture
* 🪵 Structured Logging with MDC
* ⚙️ Dynamic Configuration Management
* 🎲 Dynamic Test Data Generation
* 🧪 Data-Driven Testing
* 🔥 Headless Browser Execution
* 🛡️ Robust Exception Handling
* 🏗️ Enterprise-Level Scalability

---

# ✨ Core Features

| Feature                   | Description                    |
| ------------------------- | ------------------------------ |
| ✅ Parallel Execution      | Execute tests concurrently     |
| ✅ Thread-Safe Drivers     | Uses `ThreadLocal<WebDriver>`  |
| ✅ Multi-Browser Support   | Chrome, Firefox, Edge          |
| ✅ Dynamic Faker Test Data | Realistic randomized test data |
| ✅ POM Architecture        | Clean page abstraction         |
| ✅ Allure Reporting        | Rich execution reporting       |
| ✅ Screenshot Capture      | Auto screenshots on failure    |
| ✅ Structured Logging      | SLF4J + Logback + MDC          |
| ✅ Runtime Config Override | JVM system property support    |
| ✅ Data-Driven Testing     | Parallel TestNG DataProviders  |
| ✅ Headless Execution      | CI/CD optimized execution      |
| ✅ Custom Exceptions       | Centralized error handling     |
| ✅ Builder Pattern         | Immutable test data objects    |
| ✅ Enterprise Ready        | Clean scalable architecture    |

---

# 🏗️ Framework Architecture

```text
src
├── main
│   └── java
│       └── com.amalw
│           ├── base
│           ├── config
│           ├── datagenerator
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

| Technology            | Purpose               |
| --------------------- | --------------------- |
| ☕ Java 17             | Programming Language  |
| 🌐 Selenium WebDriver | Browser Automation    |
| 🧪 TestNG             | Test Framework        |
| 📊 Allure Reports     | Reporting             |
| 📦 Maven              | Dependency Management |
| 🔧 WebDriverManager   | Driver Management     |
| 🎲 DataFaker          | Dynamic Test Data     |
| 🪵 SLF4J              | Logging API           |
| 📝 Logback            | Logging Framework     |
| 🧰 Lombok             | Boilerplate Reduction |

---

# 🎲 Dynamic Test Data Generation

The framework uses **DataFaker** to generate realistic and randomized test data.

## ✨ Features

* Random user generation
* Dynamic email creation
* Random passwords
* Random company names
* Random gender selection
* Parallel-safe Faker instances

---

## 🧵 Thread-Safe Faker Implementation

```java
private static final ThreadLocal<Faker> FAKER =
    ThreadLocal.withInitial(() ->
        new Faker(new Locale("en-US")));
```

---

## 👤 Example User Generation

```java
User.builder()
    .firstName(faker.name().firstName())
    .lastName(faker.name().lastName())
    .email(EmailUtils.generateUniqueEmail())
    .company(faker.company().name())
    .password(password)
    .confirmPassword(password)
    .build();
```

---

# 🧪 Test Coverage

The framework includes both positive and negative test scenarios.

## ✅ Positive Test Coverage

### `RegistrationTest`

Covers:

* Successful user registration
* Parallel execution
* Cross-browser validation
* Success message validation

---

## ❌ Negative Test Coverage

### `RegistrationNegativeTest`

Covers:

* Invalid email validation
* Empty required fields
* Password mismatch
* Weak password validation
* Input validation checks

---

# 🧱 Page Object Model (POM)

The framework follows the Page Object Model design pattern.

## ✨ BasePage Features

* Click handling
* Typing operations
* Explicit waits
* Visibility checks
* Navigation helpers
* Robust exception handling

```java
protected void click(By locator)
protected void type(By locator, String text)
protected String getText(By locator)
```

---

# 🌐 Browser Support

| Browser | Supported |
| ------- | --------- |
| Chrome  | ✅         |
| Firefox | ✅         |
| Edge    | ✅         |

---

# 🔥 Headless Execution Support

Optimized browser configurations for CI/CD pipelines.

## Chrome Headless Optimizations

```java
options.addArguments(
    "--headless=new",
    "--window-size=1920,1080",
    "--disable-gpu",
    "--no-sandbox",
    "--disable-dev-shm-usage"
);
```

---

# 🔧 Configuration Management

Centralized configuration handling using `ConfigManager`.

## ✨ Features

* Config file loading
* JVM runtime overrides
* Default value fallback
* Boolean & integer parsing
* Validation handling
* Structured config logging

---

## 📄 Example Config

```properties
base.url=https://demo.nopcommerce.com
browser=chrome
headless=false
grid=false
retries=1
pageLoadTimeout=60
registration.test.data.count=5
screenshot.dir=screenshots
```

---

## ⚡ Runtime Override Example

```bash
mvn clean test -Dbrowser=firefox -Dheadless=true
```

---

# 🧵 Parallel Execution

Fully thread-safe framework architecture using:

```java
private static final ThreadLocal<WebDriver> TLDRIVER =
        new ThreadLocal<>();
```

---

# ✨ Benefits of ThreadLocal Architecture

* Independent browser sessions
* No thread collision
* Safe parallel execution
* Faster execution
* Better scalability
* CI/CD friendly execution

---

# 🧪 TestNG Parallel Configuration

```xml
<suite name="ParallelSuite"
       parallel="methods"
       thread-count="12">
```

---

# 📊 Allure Reporting

Generate execution results:

```bash
mvn clean test
```

Serve report:

```bash
allure serve allure-results
```

Generate static report:

```bash
allure generate allure-results --clean -o allure-report
```

---

# 📄 Allure Features

* ✅ Step-level execution tracking
* ✅ Failure screenshots
* ✅ Severity tracking
* ✅ Epic / Feature / Story grouping
* ✅ Execution timeline
* ✅ Parallel execution visibility
* ✅ Stack trace analysis

---

# 📸 Screenshot Capture

Screenshots are automatically captured on failures.

## 📁 Screenshot Structure

```text
screenshots/
├── RegistrationTest/
└── RegistrationNegativeTest/
```

---

# 🪵 Logging System

The framework uses:

* SLF4J
* Logback
* MDC Context Logging

---

# ✨ Logging Features

* Console logging
* Rolling file logging
* Browser tracking
* Thread identification
* Execution timing
* Structured log formatting

---

# 📁 Log Storage

```text
logs/
├── automation.log
└── archived/
```

---

# 🛡️ Exception Handling

Centralized exception handling using:

```java
FrameworkException
```

---

# ✅ Benefits

* Cleaner stack traces
* Easier debugging
* Better maintainability
* Standardized failures
* Improved reporting clarity

---

# 🧩 Core Framework Components

| Component             | Responsibility                 |
| --------------------- | ------------------------------ |
| `ConfigManager`       | Configuration handling         |
| `ConfigPrinter`       | Execution config logging       |
| `DriverFactory`       | Thread-safe driver lifecycle   |
| `BrowserManager`      | Browser creation               |
| `FakeDataGenerator`   | Faker instance management      |
| `BasePage`            | Common Selenium actions        |
| `RegisterPage`        | Registration page interactions |
| `UserTestDataFactory` | Dynamic user generation        |
| `ScreenshotManager`   | Screenshot utility             |
| `BaseTest`            | Test setup & teardown          |
| `AllureListener`      | Reporting & screenshots        |

---

# 🧱 Design Patterns Used

| Pattern                | Usage                  |
| ---------------------- | ---------------------- |
| Page Object Model      | Page abstraction       |
| Factory Pattern        | Driver & data creation |
| Builder Pattern        | Immutable user objects |
| Singleton-Style Config | Shared configuration   |
| ThreadLocal Pattern    | Parallel execution     |
| Fluent Interface       | Page method chaining   |
| Utility Pattern        | Reusable helpers       |

---

# 🧪 Sample Test Flow

```text
1. Initialize Driver
2. Open Registration Page
3. Generate Dynamic User
4. Fill Registration Form
5. Submit Registration
6. Validate Results
7. Capture Screenshot on Failure
8. Generate Allure Report
9. Quit Driver
```

---

# 🚀 Running Tests

## ▶️ Run All Tests

```bash
mvn clean test
```

---

## ⚡ Run Headless

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

# 📌 Enterprise-Level Capabilities

* Centralized configuration
* Dynamic runtime execution
* Parallel scalability
* Structured logging
* Failure screenshot support
* CI/CD ready execution
* Clean modular architecture
* Reusable page components
* Extensible framework structure
* Realistic test data generation

---

# 🔮 Future Enhancements

* 🔄 Retry Analyzer
* ☁ Selenium Grid Integration
* 🐳 Docker Support
* ⚙ Jenkins Pipeline
* 📱 Mobile Automation
* 📡 API Testing Integration
* ☁ Cloud Execution Support
* 📈 Advanced Reporting Dashboard

---

# 👨‍💻 Author

## Amal W

---

# ⭐ Support

If you found this framework useful:

* ⭐ Star the repository
* 🍴 Fork the project
* 🛠 Contribute improvements

---

<div align="center">

## 💙 Happy Testing 💙

</div>
