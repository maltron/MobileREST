# Import the correct variables
source wildfly.sh
${WILDFLY_LOCATION}/bin/jboss-cli.sh --connect --command="deploy target/Person-1.0-SNAPSHOT.war --name=Person --runtime-name=Person-1.0-SNAPSHOT.war"
