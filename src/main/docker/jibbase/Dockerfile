FROM debian AS build-env

# Add CA files
RUN apt-get update

RUN apt install -y -q graphviz
RUN whereis graphviz
RUN apt-get install -y -q  openjdk-8-jdk
