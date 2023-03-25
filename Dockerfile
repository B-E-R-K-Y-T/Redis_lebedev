ARG DOCKER_DEPENDENCY_IMAGE="gradle:7.6.1-jdk11"
ARG DOCKER_RUNTIME_IMAGE="openjdk:11-jre-slim"

FROM ${DOCKER_DEPENDENCY_IMAGE} as dependency-image

WORKDIR /build

COPY ./gradle ./gradle
COPY \
    ./build.gradle \
    ./gradle.properties \
    ./settings.gradle \
    ./

RUN gradle dependencies --no-daemon


FROM dependency-image as compile-image

COPY ./src ./src
RUN gradle build --no-daemon


FROM ${DOCKER_RUNTIME_IMAGE} as runtime-image

ARG APP_HOME="/app"
ENV APP_HOME=${APP_HOME}

WORKDIR "${APP_HOME}"

COPY --from=compile-image /build/build/libs/shop-with-redis-shop-with-redis.jar ./app.jar

COPY docker-entrypoint.sh /usr/local/bin/docker-entrypoint.sh
RUN chmod +x /usr/local/bin/docker-entrypoint.sh && \
    ln -s /usr/local/bin/docker-entrypoint.sh /

EXPOSE 8080

ENTRYPOINT [ "docker-entrypoint.sh" ]
CMD [ "app" ]
