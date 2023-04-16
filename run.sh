#!/bin/zsh

_kafka() {
  KAFKA_HOST_NAME="localhost" docker-compose up kafka
}

_kafka_detach() {
  KAFKA_HOST_NAME="localhost" docker-compose up --detach kafka
}

_postgres() {
  docker-compose up --detach db
}

# Run kafka and expose brokers on localhost: sh run.sh -k
if [ "$1" == '-k' ]; then
  _kafka_detach
  exit 0
fi

# Run postgres : sh run.sh -p
if [ "$1" == '-p' ]; then
  _postgres
  exit 0
fi

# Run postgres and kafka: sh run.sh -pk
if [ "$1" == '-pk' ] || [ "$1" == '-kp' ]; then
  _postgres
  _kafka
  exit 0
fi

# Run all containers and local app jar: sh run.sh
if [ "$1" == '-B' ] || [ ! -f ./application/target/application-sb.jar ]; then
  mvn -B clean package -DskipTests
fi

_postgres
_kafka_detach
java -jar ./application/target/application-sb.jar
