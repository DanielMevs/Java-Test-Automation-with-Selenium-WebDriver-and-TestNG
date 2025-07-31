# Practice Test Automation - Selenium Test Suite

A comprehensive Selenium WebDriver test automation framework built using Java, TestNG, and the Page Object Model (POM) design pattern. This project demonstrates automated testing of web applications with proper exception handling and cross-browser support.

## 🏗️ Project Structure

```
project-root/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/practicetestautomation/tests/pageobjects/
│   │   │       ├── BasePage.java
│   │   │       ├── ExceptionsPage.java
│   │   │       ├── LoginPage.java
│   │   │       └── SuccessfulLoginPage.java
│   │   └── resources/
│   │       └── msedgedriver.exe
│   └── test/
│       ├── java/
│       │   └── com/practicetestautomation/tests/
│       │       ├── BaseTest.java
│       │       ├── exceptions/
│       │       │   └── ExceptionsTests.java
│       │       └── login/
│       │           └── LoginTests.java
│       └── resources/
│           └── TestSuites/
│               ├── DebugSuite.xml
│               ├── FullRegressionSuite.xml
│               └── SmokeTestSuite.xml
```

## 🛠️ Technologies Used

- **Java** - Programming language
- **Selenium WebDriver** - Web automation framework
- **TestNG** - Testing framework
- **Maven** - Dependency management (assumed)
- **Page Object Model** - Design pattern for maintainable test code

## 🚀 Features

### Cross-Browser Support
- **Chrome** (default)
- **Firefox**
- **Microsoft Edge**
- **Parallel cross-browser execution** via TestNG suites

### Test Categories
- **Positive Tests** - Happy path scenarios
- **Negative Tests** - Error handling and validation
- **Smoke Tests** - Critical functionality verification
- **Regression Tests** - Full test suite execution

### Exception Handling Tests
- NoSuchElementException handling
- TimeoutException handling
- ElementNotInteractableException handling
- InvalidElementStateException handling
- StaleElementReferenceException handling

## 📋 Prerequisites

Before running the tests, ensure you have:

1. **Java 8+** installed
2. **Maven** installed
3. **Browser drivers** (handled automatically by Selenium Manager for Chrome/Firefox)
4. **Maven** installed (for dependency management)

## 🏃‍♂️ Running Tests

### Run All Tests
```bash
mvn test
```

### Run Test Suites
```bash
# Run smoke test suite
mvn test -DsuiteXmlFile=src/test/resources/TestSuites/SmokeTestSuite.xml

# Run full regression suite
mvn test -DsuiteXmlFile=src/test/resources/TestSuites/FullRegressionSuite.xml

# Run debug suite
mvn test -DsuiteXmlFile=src/test/resources/TestSuites/DebugSuite.xml
```

### Run Specific Test Groups
```bash
# Run smoke tests only
mvn test -Dgroups=smoke

# Run regression tests
mvn test -Dgroups=regression

# Run positive tests
mvn test -Dgroups=positive

# Run negative tests
mvn test -Dgroups=negative
```

### Run Tests with Specific Browser
```bash
# Run with Chrome (default)
mvn test -Dbrowser=chrome

# Run with Firefox
mvn test -Dbrowser=firefox

# Run with Edge
mvn test -Dbrowser=edge
```

### Run Specific Test Classes
```bash
# Run login tests only
mvn test -Dtest=LoginTests

# Run exception tests only
mvn test -Dtest=ExceptionsTests
```

### Parameterized Tests
For negative login tests, you can pass parameters via TestNG XML configuration:

```xml
<parameter name="username" value="invalidUser"/>
<parameter name="password" value="invalidPassword"/>
<parameter name="expectedErrorMessage" value="Your username is invalid!"/>
```

## 🧪 Test Scenarios

### Login Tests (`LoginTests.java`)

#### Positive Test
- **testLoginFunctionality**: Validates successful login with valid credentials
    - Username: `student`
    - Password: `Password123`
    - Verifies successful redirect and logout button presence

#### Negative Test
- **negativeLoginTest**: Validates error handling with invalid credentials
    - Parameterized test for different invalid combinations
    - Verifies appropriate error messages are displayed

### Exception Tests (`ExceptionsTests.java`)

#### NoSuchElementException Test
- Tests handling of elements that don't exist initially
- Validates dynamic element appearance after user interaction

#### TimeoutException Test
- Tests waiting mechanisms for delayed elements
- Ensures proper timeout handling

#### ElementNotInteractableException Test
- Tests interaction with elements that become interactable
- Validates element state changes

#### InvalidElementStateException Test
- Tests editing functionality on form elements
- Validates element state transitions

#### StaleElementReferenceException Test
- Tests handling of elements that become stale after DOM changes
- Validates element reference updates

## 📁 Page Object Classes

### BasePage
- **Purpose**: Common functionality for all page objects
- **Features**:
    - WebDriver and WebDriverWait initialization
    - Common wait methods (`waitForElement`, `waitForIsDisplayed`, `waitForIsHidden`)
    - URL and page source utilities

### LoginPage
- **URL**: `https://practicetestautomation.com/practice-test-login/`
- **Methods**: Username/password input, login execution, error message retrieval

### SuccessfulLoginPage
- **Features**: Logout button verification and page loading confirmation

### ExceptionsPage
- **URL**: `https://practicetestautomation.com/practice-test-exceptions/`
- **Features**: Dynamic element interaction, form manipulation, success message validation

## 🔧 Configuration

### Test Suite Configuration
The project includes pre-configured TestNG XML suites located in `src/test/resources/TestSuites/`:

- **SmokeTestSuite.xml**: Runs all tests marked with `@Test(groups = {"smoke"})` - includes positive login functionality
- **FullRegressionSuite.xml**: Comprehensive cross-browser testing suite that includes:
    - Positive login tests on Chrome and Firefox
    - Negative login tests with invalid username (Firefox) and password (Edge)
    - Complete exception handling tests (Chrome)
- **DebugSuite.xml**: Single test for debugging - runs only `noSuchElementExceptionTest`

### Browser Configuration
The framework automatically handles browser driver management:
- Chrome and Firefox use Selenium Manager (automatic driver download)
- Edge uses Selenium Manager (automatic driver download)
- Cross-browser testing is configured in `FullRegressionSuite.xml`

### Wait Configuration
- Default explicit wait timeout: **10 seconds**
- Configurable through `WebDriverWait` in `BasePage`

### Logging
- Uses Java's built-in logging framework
- Log level set to `INFO`
- Logs browser selection and test execution details

## 🎯 Best Practices Implemented

1. **Page Object Model**: Separates test logic from page-specific code
2. **Explicit Waits**: Robust element waiting strategies
3. **Exception Handling**: Graceful handling of common Selenium exceptions
4. **Cross-Browser Testing**: Support for multiple browsers
5. **Test Grouping**: Organized test execution with TestNG groups
6. **Parameterized Testing**: Flexible test data management
7. **Logging**: Comprehensive test execution logging

## 🐛 Troubleshooting

### Common Issues

1. **Browser Driver Issues**
    - Ensure browser versions are compatible
    - For Edge, verify `msedgedriver.exe` is in the correct location

2. **Element Not Found**
    - Check if page load is complete
    - Verify locator strategies are correct
    - Increase wait timeouts if necessary

3. **Test Failures**
    - Check browser console for JavaScript errors
    - Verify test URLs are accessible
    - Ensure test data is valid

## 📈 Future Enhancements

- Add support for parallel test execution
- Implement screenshot capture on test failures
- Add reporting with TestNG or Allure
- Include API testing capabilities
- Add database validation tests
- Implement CI/CD pipeline integration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add appropriate tests
5. Submit a pull request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Note**: This test suite is designed to work with the Practice Test Automation website. Ensure the target URLs are accessible when running the tests.