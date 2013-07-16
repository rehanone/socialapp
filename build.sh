#!/bin/bash

rm -rf dist
mvn clean install
mkdir dist
cp -v app/target/*.jar dist/
