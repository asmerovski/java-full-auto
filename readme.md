# Java Automation

## Technologies
- Java openjdk version "11.0.16.1" 2022-08-12
- Apache Maven 3.8.6
- Rest Assured 5.2.0
- Selenium 4.5.3
- JUnit 5.9.1
- Allure reports 2.19.0

## Running the tests
In order to run tests you need to:

- clone the project
- `run mvn clean install -DskipTests`
- `run mvn test`

## Run tests and build/serve test results
In order to have Allure reports runnable in local, please install it

`brew install allure`

To run tests and generate results in the same command: 
- `mvn clean verify allure:serve`

## Run tests against specific environment
To specify test environment use `-Deut={env}`, i.e. `-Deut=local`

## Run only specific tags
To specify test environment use `-Dtags=[tags]`, i.e. `-Deut=mobile`, `-Deut=mobile,rest`

## Run Allure docker locally
- `docker-compose up allure allure-ui`
- (one time deal) `chmod +x post-allure-result.sh`
- run bash script from above (prerequisite is that your tests have run at least once so you have some allure results in the project)
`./post-allure-result.sh`
- open `http://localhost:5252/allure-docker-service-ui/` 
- open default project
- click GENERATE REPORT