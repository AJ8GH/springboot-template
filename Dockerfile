FROM maven:3.9.9-amazoncorretto-17
WORKDIR /app
COPY . /app
RUN mvn -B clean package -DskipTests -Pdocker
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/app/application/target/application-sb.jar"]
