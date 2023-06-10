# **UI tests for StellarBurgers project.**

### Annotation.

Project includes UI tests for [StellarBurgers](https://stellarburgers.nomoreparties.site/). Tests are completed as a part of training course "QA Automation Engineer (Java)" from Yandex Praktikum.

### Libraries and Frameworks.

Tests are uses:
* Java 11.0.2;
* JUnit 4.13.2;
* Mockito 4.7.0;
* Allure 2.22.0;
* Maven 3.8.1;
* Selenide 5.23.2;
* Maven-surefire-plugin 2.22.2;
* RestAssured 4.4.0;

### Test coverage

#### **User signUp:**
* Success SignUp;
* Mistake for incorrect password. Min. password - 6 symbols;

#### User signIn:
* SignIn via "Enter" button;
* SignIn via "UserProfile" button;
* SignIn via registration form;
* SignIn via "RecoveryPassword" button;

#### Move into User Profile:
* Move by button "UserProfile".

#### Move into constructor via UserProfile:
* Move by button "UserProfile" and via logo.

#### LogOut:
* User is logged out by button "LogOut".

#### Constructor:
* Try to move in "buns";
* Try to move in "sauces";
* Try to move in "fillings";

### Test run

Tests run: `mvn clean test`

Allure report run:  `mvn allure:serve`

Allure test coverage: target/allure-results