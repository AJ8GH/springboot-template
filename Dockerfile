FROM maven:3.9.7-amazoncorretto-17
WORKDIR /app
COPY . /app
RUN mvn -B clean package -DskipTests -Pdocker
EXPOSE 8080
CMD ["java", "-jar", "/app/application/target/application-sb.jar"]
