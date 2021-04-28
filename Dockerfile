FROM    maven:3.6.3-jdk-8
RUN     mkdir /tests
WORKDIR /tests
COPY    . .
CMD mvn clean verify allure:report