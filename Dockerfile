FROM rrojano/spring-boot
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn -DskipTests clean package

EXPOSE 8080

CMD ["java", "-jar", "/app/target/inventario-backend-0.0.1-SNAPSHOT.jar"]

