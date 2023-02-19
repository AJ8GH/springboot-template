#!/bin/zsh

mvn -B clean package -DskipTests
java -jar ./application/target/application-sb.jar
