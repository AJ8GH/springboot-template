#!/bin/zsh

if [ "$1" == '-B' ] || [ ! -f ./application/target/application-sb.jar ]; then
  mvn -B clean package -DskipTests
fi

docker-compose up --detach db
java -jar ./application/target/application-sb.jar
