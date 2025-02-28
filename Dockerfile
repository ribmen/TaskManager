# Use an official Maven image as the base image
FROM maven:3-sapmachine-21 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests
# BUILD

# Use an official OpenJDK image as the base image
# EXECUÇÃO
FROM ibm-semeru-runtimes:open-21-jre-focal
# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/task-manager-0.1.jar task-manager.jar
# Set the command to run the application
CMD ["java", "-jar", "task-manager.jar"]