#!/bin/zsh

mvn clean package -DskipTests
java -jar ./application/target/application-sb.jar
