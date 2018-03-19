# spring-boot-docker-sample

This application demonstrates how Spring-boot application can be dockarized and can be run inside docker image.

-> I have used maven plugin which creates docker image for the Spring-boot application while we are building the project.

	<build>
		<finalName>app</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>2.0.0.RELEASE</version>
			</plugin>
			<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>docker-maven-plugin</artifactId>
				<version>0.2.3</version>
				<configuration>
					<imageName>springboottest</imageName>
					<dockerDirectory>src/main/docker</dockerDirectory>
					<resources>
						<resource>
							<targetPath>/</targetPath>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
  -> To build the project, we will run following command...
  mvn clean package docker:build
  
  -> So our spring boot application will be built and "springboottest" docker image will be created.
  You can verify it by running "docker images" command.
  
  -> To run the generated docker image, please run following command:
  docker run -p 8080:8080 springboottest
  
  This command will map 8080 port of container with 8080 port of docker.
  
  -> To test whether our application has successfully started inside docker container, please make following GET request:
  
  HTTP request : GET
  URL : localhost:8080/arsenal/players
  
  Response:
  [
    {
        "number": 10,
        "name": "Jack Wilshere"
    },
    {
        "number": 6,
        "name": "Laurent Koscielny"
    },
    {
        "number": 4,
        "name": "Per Mertsacker"
    },
    {
        "number": 10,
        "name": "Aaron Ramsey"
    },
    {
        "number": 11,
        "name": "Mesut Ozil"
    }
  ]
  
  -> If you are getting above mentioned response, then we have successfully integrated docker with our Spring-boot application.
