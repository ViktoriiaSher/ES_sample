# Intro

This is an automated testing excercise for Emilie Scientific. I focused on front-end testing only.
1. The “application” under test is the google form at https://forms.gle/4U478yAnzxMeXrdp8
2. Create an automated test suite that validates and exercises the user stories listed below.
3. Tests can use the language / test runner / framework of your choice. Use of a BDD framework
such as Cucumber is encouraged but not required.

## Instalation
1. Install Homebrew: https://brew.sh/
2. Install Java 8.0: brew cask install java8
3. Install and configure Maven in your bash_profile or brew install mvn
4. Install IntelliJ: https://www.jetbrains.com/idea/download/#section=mac or brew cask install intellij-idea
5. Install node: brew install node
6. Install Selenium WebDriver: https://www.seleniumhq.org/download/ of brew install selenium-server-standalone
7. Install ChromeDriver: http://chromedriver.chromium.org/downloads
8. Clone this repo
9. Import this project in your intelliJ idea as Maven project

## Usage
1. Open terminal
2. CD to the project directory:
3. Goto config.properties file and make required changes before running the test
4. Enter: mvn clean test to run the test (Note: you can run individual tags using this command mvn test -Dcucumber.options="--tags @positive-submission")
5. Enter: mvn site to generate the HTML Allure report
6. Goto this path in project directory to view the report /target/site/allure-maven-plugin/index.html


## Requirements

1. As a user submitting a form entry, I want to submit all data and receive a response from
the server indicating my response was successfully recorded
2. As a user submitting a form entry, I want validations to enforce that all fields are required
3. As a user submitting a form entry, I want validations to ensure that the email addresses I
enter are properly formatted.
4. As a user submitting a form entry, I want validations to ensure that phone numbers I
enter are properly formatted
5. As a user submitting a form entry, I want validations to ensure that ZIP codes I enter are
properly formatted U.S. zip codes

## Deffects

1. Letter "S" is missing in the field name: Secondary email addres - should be Secondary email address.
2. Secondary email address field doesn't have any validation except that the field shouldn't be empty.
3. Primary email address can begin with numbers or special characters.
Email format errors:
"12345@123.123" - user can submit an email without any alphabetical characters, should contain at least 1
"___@abc.com" - same as above, can submit
"_xyz@xyz.com" -  first character must be alpha-numeric
"a"(),:;<>[\]@gmail.com" - error message doesn't provide any description on what characters are NOT allowed


## Contributing

1. Fork it.
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :)

## History

TODO: Write history

## Credits

1. Viktoriia Sheremet
