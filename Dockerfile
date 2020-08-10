FROM markhobson/maven-chrome:latest

ADD ./frontEnd/src ./frontEnd/src
ADD ./frontEnd/test-output ./frontEnd/test-output
ADD ./frontEnd/testng-suites ./frontEnd/testng-suites
ADD ./frontEnd/target ./frontEnd/target
ADD ./frontEnd/pom.xml ./frontEnd/pom.xml

RUN mkdir ./frontEnd/Log4j

WORKDIR frontEnd

RUN mvn clean --file pom.xml \
    && mvn compile \
    && mvn install -DskipTests

CMD ["mvn", "install"]