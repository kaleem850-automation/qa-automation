## QA UI Automation Framework with Cypress

### Highlights
* Page object model
* BDD with Cucumber
* Beautiful HTML Reports
* Execute the scripts in Docker container
* Modular structure
* Easy maintenance

### Pre - requisites
* JDK 8+
* Maven 3
* Chrome or any other browser supported by Selenium
* Git(Optional - Needed only if you want to clone this project)
* IDE(Optional - Needed if you want to do any changes to this project)
* Docker(Optional - Needed only if you want to execute the scripts in docker container)

### Steps to run in local
* Clone or download the project
* Execute the command `mvn clean verify` to exeucte the scripts in chrome browser
* Execute the command `mvn clean cerify -Dbrowser=firefox` to exeucte the scripts in firefox browser
* Execute the command `mvn allure:report` to generate the HTML reports (HTML Reports are generated in `target/site`)

### Steps to run in docker container
* To build docker images with scripts included
    * Execute the command `docker build -t <imagename> .`
    * Execute the command `docker container start -i <id>` to execute the scripts


