FROM eclipse-temurin:17.0.7_7-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew shadowJar

FROM eclipse-temurin:17.0.7_7-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/knubot_discord-all.jar .
CMD [ "java", "-jar", "knubot_discord-all.jar" ]
