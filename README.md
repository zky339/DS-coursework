# DS-coursework
#Based upon https://github.com/sajeerzeji/SpringBoot-GRPC Commands for preparing the enviornment (Assuming you are in the main folder e.g. the one with the pom.xml file in it)

#sudo apt update
#sudp apt install default-jdk maven git
#git clone https://github.com/zky339/DS-coursework.git
#cd ECS796P-Lab4/grpc-server
(From grpc-server folder) mvn package -Dmaven.test.skip=true
(From grpc-server folder) chmod 777 mvnw
(From grpc-server folder) ./mvnw spring-boot:run -Dmaven.test.skip=true
cd ECS796P-Lab4/grpc-client
(From grpc-client folder e.g. seperate ssh connection) mvn package -Dmaven.test.skip=true
(From grpc-client folder e.g. seperate ssh connection) chmod 777 mvnw
(From grpc-client folder e.g. seperate ssh connection) ./mvnw spring-boot:run -Dmaven.test.skip=true
rm -rf ECS796P-Lab4
http://35.239.9.155:8082/add
http://35.239.9.155:8082/multiply
