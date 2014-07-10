#!/bin/sh

echo "************ CLEANING *******************"
mvn clean
echo "************ UNDEPLOYING *******************"
asadmin undeploy jeedemo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/jeedemo.war
