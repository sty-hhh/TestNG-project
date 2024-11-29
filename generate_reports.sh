mvn test
mvn allure:serve
mvn jacoco:report
cp -r target/surefire-reports reports/surefire-reports
cp -r target/site/jacoco reports/test-coverage-report