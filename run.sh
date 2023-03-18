#!/bin/zsh

mvn -B clean package -DskipTests
docker-compose up db
java -jar ./application/target/application-sb.jar
